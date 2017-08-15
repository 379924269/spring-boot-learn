package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.Config;
import com.dnp.bootstarp.dao.ConfigMapper;
import com.dnp.bootstarp.service.ConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配置信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
