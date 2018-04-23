package com.dnp.bootstarp.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 华仔
 * @date 2018/4/12 15:45
 */
@Component
public class LoggerToggleProperties {
    @Value("${demo.logger-open}")
    private boolean loggerOpen;

    public boolean isLoggerOpen() {
        return loggerOpen;
    }

    public void setLoggerOpen(boolean loggerOpen) {
        this.loggerOpen = loggerOpen;
    }
}
