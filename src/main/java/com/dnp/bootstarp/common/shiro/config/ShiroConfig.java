package com.dnp.bootstarp.common.shiro.config;

import com.dnp.bootstarp.common.shiro.MyRealm;
import com.dnp.bootstarp.common.shiro.filter.RetryLimitHashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by huazai on 2017/8/15.
 */
@Component
public class ShiroConfig {

    /*写一个密码次数验证*/
    @Bean
    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(EhCacheManager ehCacheManager) {
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(ehCacheManager);
        retryLimitHashedCredentialsMatcher.setHashAlgorithmName("md5");
        retryLimitHashedCredentialsMatcher.setHashIterations(0);
        retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return retryLimitHashedCredentialsMatcher;
    }

     /*=======自己的realm，用来设置权限的验证用户======*/
    @Bean(name = "myRealm")
    public MyRealm myRealm(RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher);
        myRealm.setCachingEnabled(Boolean.FALSE);
        return myRealm;
    }

    @Bean(name = "securityManager")
    public DefaultSecurityManager securityManager(SessionManager sessionManager, EhCacheManager ehCacheManager, MyRealm myRealm, CookieRememberMeManager cookieRememberMeManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(ehCacheManager);
        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }


        /*用户重复登录问题*/

//    @Bean("getKickoutSessionControlFilter")
//    public KickoutSessionControlFilter getKickoutSessionControlFilter() {
//        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
//        kickoutSessionControlFilter.setCacheManager(getEhCacheManager());
//        kickoutSessionControlFilter.setSessionManager(sessionManager());
//        kickoutSessionControlFilter.setKickoutAfter(Boolean.FALSE);
//        kickoutSessionControlFilter.setMaxSession(1);
//        kickoutSessionControlFilter.setKickoutUrl("/login/login");
//        return kickoutSessionControlFilter;
//    }

    /**
     * 没有登陆会自动跳转到setLoginUrl
     *
     * @param securityManager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login/login");
        shiroFilter.setSuccessUrl("/login/index");
        shiroFilter.setUnauthorizedUrl("/login/noPermission");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/public/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/api/**", "anon");

        filterMap.put("/login.html", "anon");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/login/login", "anon");
        filterMap.put("/login/index", "anon");
        //下面是过滤swagger的
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/favicon.ico", "anon");


//        filterMap.put("/demo/v2/api-docs", "anon");
//        filterMap.put("/demo/swagger-ui.html", "anon");
//        filterMap.put("/demo/swagger-resources/**", "anon");
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean(name = "sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /*cacheManager*/

    @Bean
    public EhCacheManager ehCacheManager() {
        // Ehcache缓存
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        //System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
