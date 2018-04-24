package com.dnp.bootstarp.common.exception.goableHander;

import com.dnp.bootstarp.common.constant.tips.ErrorTip;
import com.dnp.bootstarp.common.operateLog.OperateLogUtil;
import com.dnp.bootstarp.common.support.HttpKit;
import com.dnp.bootstarp.model.OperateLog;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author 华仔
 * @date 2017年8月17日10:16:22
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTip exception(Exception e) {
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        log.error("业务异常:", e);
        return new ErrorTip(500, e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTip unauthorizedException(Exception e) {
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        return new ErrorTip(500, "没有权限");
    }

    @ExceptionHandler(UnknownSessionException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorTip unknownSessionException(Exception e) {
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        return new ErrorTip(500, "会话已经过期");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorTip httpRequestMethodNotSupportedException(Exception e) {
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        return new ErrorTip(500, e.getMessage());
    }

}
