package com.dnp.bootstarp.common.shiro;

import com.dnp.bootstarp.common.shiro.config.IShiro;
import com.dnp.bootstarp.common.shiro.config.ShiroFactroy;
import com.dnp.bootstarp.common.support.StrKit;
import com.dnp.bootstarp.common.util.MD5Util;
import com.dnp.bootstarp.dao.ResourceMapper;
import com.dnp.bootstarp.dao.UserMapper;
import com.dnp.bootstarp.model.Resource;
import com.dnp.bootstarp.model.User;
import com.dnp.bootstarp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 这个地方@autoware注入不进来，我仿照别人的搞的
 * Created by huazai on 2017/8/15.
 */
public class MyRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("========授权=========");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        IShiro shiroFactory = ShiroFactroy.me();
        List<Resource> res = shiroFactory.findPermissionsByRoleId(user.getRoleId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Resource resource : res) {
            info.addStringPermission(resource.getResKey());

        }
        return info;
    }

    /**
     * 账号验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("========验证用户=========");
        IShiro shiroFactory = ShiroFactroy.me();
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = shiroFactory.user(token.getUsername());
        if (!StrKit.isEmpty(user.getEmail())) {
            SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, MD5Util.encrypt(user.getPassword()), super.getName());
            return sai;
        } else {
            throw new UnknownAccountException();
        }
    }
}
