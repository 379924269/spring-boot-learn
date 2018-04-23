package com.dnp.bootstarp;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Random;


/**
 * 属性测试
 *
 * @Author 华仔
 * @Author 2017/12/21 11:25
 */
public class YmlPropertiesTest extends BootstartlearnApplicationTests {
    @Value("${demo.logger-open}")
    private boolean loggerOpen;
    @Test
    public void findAll() throws Exception {
        System.out.println("=========================" + loggerOpen);
        Assert.assertTrue(loggerOpen);
    }


}
