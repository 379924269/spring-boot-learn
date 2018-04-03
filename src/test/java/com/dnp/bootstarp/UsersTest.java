package com.dnp.bootstarp;

import org.junit.Test;
import org.mockito.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Random;


/**
 * 可以测试controller、server、dao
 *
 * @Author 华仔
 * @Author 2017/12/21 11:25
 */
public class UsersTest extends BootstartlearnApplicationTests {
    Logger logger = LoggerFactory.getLogger(UsersTest.class);

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")).
                andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .param("name", "lala" + new Random().nextInt())
                .param("email", "lala@qq.com" + new Random().nextInt())
                .param("password", "123456")
                .param("createdDate", String.valueOf(System.currentTimeMillis()))
                .param("roleId", "1"))
                .andExpect(MockMvcResultMatchers.status().is(200)) //判断接收的状态是否是200
                .andDo(MockMvcResultHandlers.print());   //打印内容
    }

}
