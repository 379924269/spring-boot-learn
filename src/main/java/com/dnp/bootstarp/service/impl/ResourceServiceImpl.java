package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.model.Resource;
import com.dnp.bootstarp.dao.ResourceMapper;
import com.dnp.bootstarp.service.ResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源权限信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
