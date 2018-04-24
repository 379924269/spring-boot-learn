package com.dnp.bootstarp.common.operateLog;

import com.dnp.bootstarp.common.constant.ControllerMethodEmum;
import com.dnp.bootstarp.common.util.IpUitl;
import com.dnp.bootstarp.model.OperateLog;
import com.dnp.bootstarp.model.User;
import com.dnp.bootstarp.service.OperateLogService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 华仔
 * @date 2018/4/24 14:09
 */
public class OperateLogUtil {
    public static void logHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        boolean alreadyLogin = ObjectUtils.anyNotNull(SecurityUtils.getSubject().getPrincipal());
        if (alreadyLogin && response.getStatus() == 200) {
            int controllerMethodCode = getControllerMethodCode(request);

            if (controllerMethodCode == ControllerMethodEmum.LOGIN_LOGIN.getControllerMethodCode()) {
                LoginLog.addLoginLog(request);
            } else if (controllerMethodCode == ControllerMethodEmum.USER_ADD.getControllerMethodCode()) {
                UserLog.addLog(request, response);
            } else if (controllerMethodCode == ControllerMethodEmum.USER_UPDATE.getControllerMethodCode()) {
                UserLog.updateLog(request, response);
            } else if (controllerMethodCode == ControllerMethodEmum.USER_DELETE.getControllerMethodCode()) {
                UserLog.deleteLog(request, response);
            } else if (controllerMethodCode == ControllerMethodEmum.USER_FIND_BY_ID.getControllerMethodCode()) {
                UserLog.findByIdLog(request, response);
            } else if (controllerMethodCode == ControllerMethodEmum.USER_FIND_ALL.getControllerMethodCode()) {
                UserLog.findAllLog(request, response);
            }
        } else {
            LoggerFactory.getLogger(OperateLogUtil.class).info("未登录不记日志", request.getRequestURL());
        }
    }

    private static int getControllerMethodCode(HttpServletRequest request) {
        String requestMethod = request.getMethod();
        String servletPath = request.getServletPath();

        if (requestMethod.equalsIgnoreCase("get")) {
            if (servletPath.contains("user") && StringUtils.isNotEmpty(request.getParameter("id"))) {
                return ControllerMethodEmum.USER_FIND_BY_ID.getControllerMethodCode();
            }
        } else if (requestMethod.equalsIgnoreCase("post")) {
            if (servletPath.contains("login")) {
                return ControllerMethodEmum.LOGIN_LOGIN.getControllerMethodCode();
            } else if (servletPath.contains("user")) {
                return ControllerMethodEmum.USER_ADD.getControllerMethodCode();
            }
        } else if (requestMethod.equalsIgnoreCase("delete")) {
            if (servletPath.contains("user")) {
                return ControllerMethodEmum.USER_DELETE.getControllerMethodCode();
            }
        } else if (requestMethod.equalsIgnoreCase("put")) {
            if (servletPath.contains("user")) {
                return ControllerMethodEmum.USER_UPDATE.getControllerMethodCode();
            }
        } else {
        }
        return 0;
    }

    private static <T> T getBean(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

    public static void addLog(HttpServletRequest request, String logDescription) {
        OperateLogService operateLogService = OperateLogUtil.getBean(OperateLogService.class, request);
        OperateLog operateLogModel = new OperateLog();
        operateLogModel.setDescription(logDescription);
        operateLogModel.setUserId(((User) SecurityUtils.getSubject().getPrincipal()).getId());
        operateLogModel.setUserEmail(((User) SecurityUtils.getSubject().getPrincipal()).getEmail());
        operateLogModel.setIp(IpUitl.getCliectIp(request));
        operateLogService.insert(operateLogModel);
    }
}
