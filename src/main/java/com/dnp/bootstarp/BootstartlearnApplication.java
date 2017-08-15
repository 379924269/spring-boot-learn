package com.dnp.bootstarp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BootstartlearnApplication extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html" ).addResourceLocations("classpath:/META-INF/resources/" );
        registry.addResourceHandler("/webjars/**" ).addResourceLocations("classpath:/META-INF/resources/webjars/" );
    }

    public static void main(String[] args) {
        SpringApplication.run(BootstartlearnApplication.class, args);
    }
}
