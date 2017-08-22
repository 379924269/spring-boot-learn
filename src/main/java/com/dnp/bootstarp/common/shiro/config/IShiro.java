package com.dnp.bootstarp.common.shiro.config;

import com.dnp.bootstarp.model.Resource;
import com.dnp.bootstarp.model.User;

import java.util.List;

/**
 * 定义shirorealm所需数据的接口
 *
 * @author fengshuonan
 * @date 2016年12月5日 上午10:23:34
 */
public interface IShiro {

    /**
     * 根据账号获取登录用户
     *
     * @param account 账号
     */
    User user(String account);


    /**
     * 获取权限列表通过角色id
     *
     * @param roleId 角色id
     */
    List<Resource> findPermissionsByRoleId(Integer roleId);
}
