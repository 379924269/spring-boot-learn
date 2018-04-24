package com.dnp.bootstarp.common.constant;

/**
 * @author 华仔
 * @date 2018/4/24 15:25
 */
public enum ControllerMethodEmum {
    USER_ADD(1, "添加xx用户"),
    USER_UPDATE(2, "修改xx用户"),
    USER_DELETE(3, "删除xx用户"),
    USER_FIND_BY_ID(4, "获取用户xx详情"),
    USER_FIND_ALL(5, "查看所有用户"),
    LOGIN_LOGIN(6, "用户xx登陆");

    private int controllerMethodCode;
    private String controllerMethod;

    ControllerMethodEmum(int controllerMethodCode, String controllerMethod) {
        this.controllerMethodCode = controllerMethodCode;
        this.controllerMethod = controllerMethod;
    }

    public int getControllerMethodCode() {
        return controllerMethodCode;
    }

    public void setControllerMethodCode(int controllerMethodCode) {
        this.controllerMethodCode = controllerMethodCode;
    }

    public String getControllerMethod() {
        return controllerMethod;
    }

    public void setControllerMethod(String controllerMethod) {
        this.controllerMethod = controllerMethod;
    }
}
