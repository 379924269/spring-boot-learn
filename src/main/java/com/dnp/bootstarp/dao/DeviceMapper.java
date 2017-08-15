package com.dnp.bootstarp.dao;

import com.dnp.bootstarp.common.page.PageVo;
import com.dnp.bootstarp.model.Device;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备信息 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
public interface DeviceMapper extends BaseMapper<Device> {
    List<Map<String, Object>> findAllRelation(@Param("pageVo") PageVo pageVo, @Param("search") String search);

    Integer countAllRelation(@Param("search") String search);
}