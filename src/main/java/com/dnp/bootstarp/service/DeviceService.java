package com.dnp.bootstarp.service;

import com.dnp.bootstarp.common.page.PageVo;
import com.dnp.bootstarp.model.Device;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 设备信息 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
public interface DeviceService extends IService<Device> {

    /**
     * 获取设备及相关信息
     *
     * @param pageVo 分页参数
     * @param search 模糊查询字段
     * @return json字符串
     */
    String findAllRelation(PageVo pageVo, String search);
}
