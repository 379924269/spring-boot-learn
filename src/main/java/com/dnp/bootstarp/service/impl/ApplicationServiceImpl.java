package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.Application;
import com.dnp.bootstarp.dao.ApplicationMapper;
import com.dnp.bootstarp.service.ApplicationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 应用信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
