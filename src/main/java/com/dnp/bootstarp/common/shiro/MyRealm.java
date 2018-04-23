package com.dnp.bootstarp.common.shiro;

import com.dnp.bootstarp.common.support.StrKit;
import com.dnp.bootstarp.common.util.MD5Util;
import com.dnp.bootstarp.dao.ResourceMapper;
import com.dnp.bootstarp.dao.UserMapper;
import com.dnp.bootstarp.model.Resource;
import com.dnp.bootstarp.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 这个地方@autoware注入不进来，我仿照别人的搞的
 * Created by huazai on 2017/8/15.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Resource> res = resourceMapper.selectByRoleId(user.getRoleId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Resource resource : res) {
            if (StringUtils.isNotEmpty(resource.getResKey())) {
                info.addStringPermission(resource.getResKey());
            }

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
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.selectByName(token.getUsername());
        if (!StrKit.isEmpty(user.getEmail())) {
            SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, MD5Util.encrypt(user.getPassword()), super.getName());
            return sai;
        } else {
            throw new UnknownAccountException();
        }
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
