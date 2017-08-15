package com.dnp.bootstarp.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dnp.bootstarp.common.page.PageVo;
import com.dnp.bootstarp.common.util.JsonUtil;
import com.dnp.bootstarp.dao.DeviceMapper;
import com.dnp.bootstarp.model.Device;
import com.dnp.bootstarp.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private  DeviceMapper deviceMapper;

    @Override
    public String findAllRelation(PageVo pageVo, String search) {
        PageHelper.offsetPage(pageVo.getOffset(), pageVo.getLimit());
        return JsonUtil.createPage(deviceMapper.countAllRelation(search), deviceMapper.findAllRelation(pageVo, search)).toString();
    }
}
