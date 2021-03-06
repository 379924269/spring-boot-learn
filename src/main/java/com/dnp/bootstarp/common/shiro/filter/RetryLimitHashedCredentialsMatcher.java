package com.dnp.bootstarp.common.shiro.filter;

import com.dnp.bootstarp.common.util.LoggerUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;


public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    Logger logger = LoggerFactory.getLogger(KickoutSessionControlFilter.class);

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token,
        AuthenticationInfo info) {

        LoggerUtil.info(this.getClass(), "===登陆错误限制5次锁定10分钟===");

        String username = (String) token.getPrincipal();

        // retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);

        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }

        if (retryCount.incrementAndGet() > 5) {
            // if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);

        if (matches) {
            // clear retry count
            passwordRetryCache.remove(username);
        }

        return matches;
    }
	
	/**
	* build user password
	*/
	public String buildCredentials(String userName, String password,String credentialsSalt) {
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,ByteSource.Util.bytes(userName + credentialsSalt),userName);
		AuthenticationToken token = new UsernamePasswordToken(userName, password);
		return super.hashProvidedCredentials(token, authenticationInfo).toString();
    }
}
