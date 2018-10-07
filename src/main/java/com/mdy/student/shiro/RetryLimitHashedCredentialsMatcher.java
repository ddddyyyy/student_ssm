package com.mdy.student.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
	private Cache<String, AtomicInteger> passwordRetryCache;

	private static final Logger log = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			// 高并发下使用的线程安全的int类
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		// 自定义一个验证过程：当用户连续输入密码错误2次以上禁止用户登录一段时间
		if (retryCount.incrementAndGet() > 2) {
			throw new ExcessiveAttemptsException();
		}
		boolean match = super.doCredentialsMatch(token, info);
		log.info(String.valueOf(match));
		if (match) {
			passwordRetryCache.remove(username);
		}
		return match;
	}

}
