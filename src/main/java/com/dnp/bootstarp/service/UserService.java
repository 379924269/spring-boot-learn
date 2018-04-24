package com.dnp.bootstarp.service;

import com.baomidou.mybatisplus.service.IService;
import com.dnp.bootstarp.model.User;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
public interface UserService extends IService<User> {

    User findById(int id);
}
