package com.dnp.bootstarp.common.constant;

/**
 * Created by huazai on 2017/8/25.
 */
public enum LoginMsg {
    LOGIN_SUCCESS("登陆成功"),
    UNKNOWN_ACCOUNT_EXCEPTION("用户名称或密码错误"),
    LOCKED_ACCOUNT_EXCEPTION("账号已经被锁定"),
    EXCESSIVE_ATTEMPTS_EXCEPTION("登录验证错误次数大于5次,账户已锁定"),
    DISABLE_ACCOUNT_EXCEPTION("禁止登陆"),
    AUTHENTICATION_EXCEPTION("用户名或密码错误");

    private String responseMsg;

    LoginMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
