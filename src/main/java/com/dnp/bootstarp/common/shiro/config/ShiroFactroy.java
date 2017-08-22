package com.dnp.bootstarp.common.shiro.config;

import com.dnp.bootstarp.common.util.SpringContextHolder;
import com.dnp.bootstarp.dao.ResourceMapper;
import com.dnp.bootstarp.dao.UserMapper;
import com.dnp.bootstarp.model.Resource;
import com.dnp.bootstarp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String account) {

        User user = userMapper.selectByName(account);

//        // 账号不存在
//        if (null == user) {
//            throw new CredentialsException();
//        }
//        // 账号被冻结
//        if (user.getStatus() != ManagerStatus.OK.getCode()) {
//            throw new LockedAccountException();
//        }
        return user;
    }

    @Override
    public List<Resource> findPermissionsByRoleId(Integer roleId) {
        List<Resource> resUrls = resourceMapper.selectByRoleId(roleId);
        return resUrls;
    }
}
