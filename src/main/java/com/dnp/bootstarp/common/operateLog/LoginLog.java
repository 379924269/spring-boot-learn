package com.dnp.bootstarp.common.operateLog;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆日志
 *
 * @author 华仔
 * @date 2018/4/24 14:02
 */
public class LoginLog {
    public static void addLoginLog(HttpServletRequest request) {
        OperateLogUtil.addLog(request, "用户" + request.getParameter("username") + "登陆");
    }
}
