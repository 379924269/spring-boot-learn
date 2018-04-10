package com.dnp.bootstarp.common.exception.goableHander;

import com.dnp.bootstarp.common.constant.tips.ErrorTip;
import com.dnp.bootstarp.common.support.HttpKit;
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
        //TODO 这个异常是在请求没有权限的方法的时候报的（方法存在），如果有权限不会报错，暂时不知道怎么处理就直接异常处理了。要看看怎么处理
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        return new ErrorTip(500, "没有权限");
    }

//    /**
//     * 拦截业务异常
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(BussinessException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorTip notFount(BussinessException e) {
//       HttpKit.getRequest().setAttribute("tip", e.getMessage());
//        log.error("业务异常:", e);
//        return new ErrorTip(e.getCode(), e.getMessage());
//    }
//
//    /**
//     * 用户未登录
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ErrorTip unAuth(AuthenticationException e) {
//        log.error("用户未登陆：", e);
//        return new ErrorTip(400, "未登陆");
//    }
//
//    /**
//     * 账号被冻结
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(DisabledAccountException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ErrorTip accountLocked(DisabledAccountException e, Model model) {
//        model.addAttribute("tips", "账号被冻结");
//        return new ErrorTip(400, "账号被冻结");
//    }
//
//    /**
//     * 账号密码错误
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(CredentialsException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ErrorTip credentials(CredentialsException e, Model model) {
//        model.addAttribute("tips", "账号密码错误");
//        return new ErrorTip(400, "账号密码错误");
//    }
//
//    /**
//     * 验证码错误
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(InvalidKaptchaException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String credentials(InvalidKaptchaException e, Model model) {
//        model.addAttribute("tips", "验证码错误");
//        return "/login.html";
//    }
//
//    /**
//     * 无权访问该资源
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(UndeclaredThrowableException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public ErrorTip credentials(UndeclaredThrowableException e) {
//        log.error("权限异常!", e);
//        return new ErrorTip(BizExceptionEnum.NO_PERMITION);
//    }
//
//    /**
//     * 拦截未知的运行时异常
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorTip notFount(RuntimeException e) {
//        log.error("运行时异常:", e);
//        return new ErrorTip(BizExceptionEnum.SERVER_ERROR);
//    }
//
//    /**
//     * session失效的异常拦截
//     *
//     * @author stylefeng
//     * @Date 2017/6/7 21:02
//     */
//    @ExceptionHandler(InvalidSessionException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorTip sessionTimeout(InvalidSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("tips", "session超时");
//        assertAjax(request, response);
//        return new ErrorTip(500, "服务器异常" );
//    }
//
//    /**
//     * session异常
//     *
//     * @author stylefeng
//     * @Date 2017/6/7 21:02
//     */
//    @ExceptionHandler(UnknownSessionException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorTip sessionTimeout(UnknownSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("tips", "session超时");
//        assertAjax(request, response);
//        return new ErrorTip(400,"meiyouquanxina");
//    }
//
//    private void assertAjax(HttpServletRequest request, HttpServletResponse response) {
//        if (request.getHeader("x-requested-with") != null
//                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
//            //如果是ajax请求响应头会有，x-requested-with
//            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
//        }
//    }

}
