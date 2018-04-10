package com.dnp.bootstarp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/* 这个是直接运行的*/
//@SpringBootApplication
//public class BootstartlearnApplication extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html" ).addResourceLocations("classpath:/META-INF/resources/" );
//        registry.addResourceHandler("/webjars/**" ).addResourceLocations("classpath:/META-INF/resources/webjars/" );
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(BootstartlearnApplication.class, args);
//    }
//}

/*这个是打包成war包运行在tomcat下面的*/
@SpringBootApplication
public class BootstartlearnApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootstartlearnApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootstartlearnApplication.class, args);
    }
}
