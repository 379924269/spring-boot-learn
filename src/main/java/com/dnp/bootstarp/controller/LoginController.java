package com.dnp.bootstarp.controller;

import com.dnp.bootstarp.common.constant.LoginMsg;
import com.dnp.bootstarp.common.shiro.MyRealm;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 *
 * @author 华仔
 * @Date 2017年1月10日 下午8:25:24
 */
@Api(value = "LoginController", description = "登陆")
@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    Producer producer;

    /**
     * 跳转到主页
     */
    @ApiOperation(value = "跳转到主页", notes = "跳转到主页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return new JSONObject().put("msg", "登陆成功,跳转到主页").toString();
    }

    /**
     * 跳转到主页
     */
    @ApiOperation(value = "跳转到主页", notes = "跳转到主页")
    @RequestMapping(value = "/noPermission", method = RequestMethod.GET)
    public String noPermission(Model model) {
        return new JSONObject().put("msg", "没有权限").toString();
    }

    /**
     * 跳转到登录页面
     */
    @ApiOperation(value = "跳转到登陆页面", notes = "跳转到登陆页面")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
//        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
//            return REDIRECT + "/";
//        } else {
//            return "/login.html";
//        }
        return new JSONObject().put("msg", "请登录").toString();
    }

    /**
     * 点击登录执行的动作
     */
    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali(@ApiParam(name = "username", value = "用户email", defaultValue = "huazai@qq.com") @RequestParam(required = false, name = "username") String username,
                            @ApiParam(name = "password", value = "用户密码", defaultValue = "e10adc3949ba59abbe56e057f20f883e") @RequestParam(required = false, name = "password")
                                    String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            SecurityUtils.getSubject().login(token);
            logger.info(LoginMsg.LOGIN_SUCCESS.getResponseMsg());
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            return new JSONObject().put("message", "未知账户").toString();
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            return new JSONObject().put("message", "密码不正确").toString();
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            return new JSONObject().put("message", "账户已锁定").toString();
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数大于5次,账户已锁定");
            return new JSONObject().put("message", "用户名或密码错误次数大于5次,账户已锁定").toString();
        } catch (DisabledAccountException sae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,帐号已经禁止登录");
            return new JSONObject().put("message", "帐号已经禁止登录").toString();
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            return new JSONObject().put("message", "用户名或密码不正确").toString();
        }
        return new JSONObject().put("message", LoginMsg.LOGIN_SUCCESS.getResponseMsg()).toString();
    }

    /**
     * 退出登录
     */
    @ApiOperation(value = "退出登陆", notes = "退出登陆")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        SecurityUtils.getSubject().logout();
        return new JSONObject().put("msg", "跳转到主页logOut").toString();
    }

    /**
     * 退出登录
     */
    @ApiOperation(value = "用户同时登陆被挤下线了", notes = "用户同时登陆被挤下线了")
    @RequestMapping(value = "/kickoutUrl", method = RequestMethod.GET)
    public String kickoutUrl() {
        SecurityUtils.getSubject().logout();
        return new JSONObject().put("msg", "用户同时登陆被挤下线了").toString();
    }


    /**
     * 清除权限
     */
    @ApiOperation(value = "清除权限", notes = "清除权限")
    @RequestMapping(value = "/cleanPermissionCache", method = RequestMethod.GET)
    public String cleanPermissionCache() {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyRealm myRealm = (MyRealm) rsm.getRealms().iterator().next();
        myRealm.clearAllCachedAuthorizationInfo();
        return new JSONObject().put("msg", "OK").toString();
    }

    /**
     * 生成验证码
     */
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    @RequestMapping(value = "/kaptcha", method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = producer.createText();

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write the data out
        try {
            ImageIO.write(bi, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
