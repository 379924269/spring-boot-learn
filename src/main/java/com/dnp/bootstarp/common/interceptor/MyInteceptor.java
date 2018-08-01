package com.dnp.bootstarp.common.interceptor;

import com.dnp.bootstarp.common.operateLog.OperateLogUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 华仔
 * @date 2018/4/23 11:25
 */
public class MyInteceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //拦截器处理日志，参考地址（https://blog.csdn.net/u011521890/a   rticle/details/74990338）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //OperateLogUtil.logHandler(request, response, handler, ex);
    }
}
