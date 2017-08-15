package com.dnp.bootstarp.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"com.dnp.bootstarp.dao*"})
public class MybatisPlusConfig {

}
