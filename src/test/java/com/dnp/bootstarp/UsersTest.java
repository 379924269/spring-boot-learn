package com.dnp.bootstarp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


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
        logger.debug("=========================================================================================================");
        MockHttpServletRequestBuilder xx = MockMvcRequestBuilders.get("/user");
        ResultActions mm = mockMvc.perform(xx);

                mm.andExpect(MockMvcResultMatchers.status().is(404));
    }

}
