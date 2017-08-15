package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.Model;
import com.dnp.bootstarp.dao.ModelMapper;
import com.dnp.bootstarp.service.ModelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 型号信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements ModelService {

}
