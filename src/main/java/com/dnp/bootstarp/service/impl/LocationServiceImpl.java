package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.Location;
import com.dnp.bootstarp.dao.LocationMapper;
import com.dnp.bootstarp.service.LocationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 归属地信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationService {

}
