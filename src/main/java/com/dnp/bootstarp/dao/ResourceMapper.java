package com.dnp.bootstarp.dao;

import com.dnp.bootstarp.model.Resource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资源权限信息 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> selectByRoleId(@Param("roleId") Integer roleId);

}