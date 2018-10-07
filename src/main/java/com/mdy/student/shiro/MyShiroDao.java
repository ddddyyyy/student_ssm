package com.mdy.student.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


/**
 * Shiro的是Session操作的实现类
 * 继承CachingSessionDAO能够让read操作次数减少
 * 但update操作由于是更新用户的最新一次操作，所以调用频率高
 * 如果shiro的过滤器过滤所有的链接，那么就算是静态资源也算会调用update
 * 因此如果要减少update的调用，目前的解决方案是将对外服务的接口的url加上.do之类的标志结尾
 * shiro的过滤器只过滤这些url
 * @author MDY
 */
public class MyShiroDao extends CachingSessionDAO {

    private Logger logger = LoggerFactory.getLogger(MyShiroDao.class);

    private Cache<Object, Object> cache;

    @Override
    protected void doUpdate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        logger.info("update");
        cache.put(sessionId, session);
    }

    @Override
    protected void doDelete(Session session) {
        logger.info(generateSessionId(session).toString());
        logger.info("delete");
        cache.remove(generateSessionId(session));
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        cache.put(sessionId, session);
        logger.info("create");
        logger.info(sessionId.toString());
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        logger.info("read");
        logger.info(sessionId.toString());
        return (Session) cache.get(sessionId);
    }

    @Autowired
    public void setCacheManager(EhCacheManager cacheManager) {
        cache = cacheManager.getCache("user");
    }
}
