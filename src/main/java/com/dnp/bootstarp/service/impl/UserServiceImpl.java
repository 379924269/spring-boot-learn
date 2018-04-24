package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.User;
import com.dnp.bootstarp.dao.UserMapper;
import com.dnp.bootstarp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "findUserById", key = "#id")
    @Override
    public User findById(int id) {
        return userMapper.selectById(id);
    }
}
