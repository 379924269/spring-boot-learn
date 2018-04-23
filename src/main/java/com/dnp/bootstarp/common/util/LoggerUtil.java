package com.dnp.bootstarp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author 华仔
 * @date 2018/4/12 14:50
 */
public class LoggerUtil {
    @Value("${demo.logger-open}")
    private boolean loggerOpen;
    private Logger getLogger(Class clazz) {
        System.out.println("==========" + loggerOpen);
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * 打印loggerMsg
     *
     * @param clazz     类名称(可以用this.getClass)
     * @param loggerMsg 日志信息
     */
    public static void info(Class clazz, String loggerMsg) {
        new LoggerUtil().getLogger(clazz).info(loggerMsg);
    }


}
