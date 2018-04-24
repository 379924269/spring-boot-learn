package com.dnp.bootstarp.common.operateLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆日志
 *
 * @author 华仔
 * @date 2018/4/24 14:02
 */
public class UserLog {
    public static void addLog(HttpServletRequest request, HttpServletResponse response) {
        OperateLogUtil.addLog(request, "添加用户" + request.getParameter("email"));
    }

    public static void updateLog(HttpServletRequest request, HttpServletResponse response) {
        OperateLogUtil.addLog(request, "修改用户" + request.getParameter("email"));
    }

    public static void deleteLog(HttpServletRequest request, HttpServletResponse response) {
        OperateLogUtil.addLog(request, "删除用户" + request.getParameter("email"));
    }

    public static void findAllLog(HttpServletRequest request, HttpServletResponse response) {
        OperateLogUtil.addLog(request, "获取所有用户用户");
    }

    public static void findByIdLog(HttpServletRequest request, HttpServletResponse response) {
        OperateLogUtil.addLog(request, "获取用户" + request.getParameter("email") + "详情");
    }
}
