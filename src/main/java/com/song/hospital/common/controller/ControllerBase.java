package com.song.hospital.common.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.hospital.common.redis.RedisBaseDao;
import com.song.hospital.vo.UserVO;

/**
 * spring mvc控制器层的基类，对session访问提供统一方法，子类应该使用基类提供的方法，以方便今后的集群部署（届时只需要修改此类中的实现即可）
 */
public abstract class ControllerBase {

	protected Logger log = LoggerFactory.getLogger(ControllerBase.class);

	public static final String UTF_8 = "UTF-8";

	// 会话中存储user信息的KEY
	public static final String SESSION_USER_KEY = "session_user_key";

	public static final String SESSION_USERVO_KEY_PREFIX = "sessions:uservo:token:";

	// 创建线程本地变量
	protected static final ThreadLocal<UserVO> currentLoginUser = new ThreadLocal<UserVO>();

	@Autowired
	protected RedisBaseDao redisBaseDao;

	/**
	 * Removes the current thread's value for this thread-local variable.
	 */
	public static void clearThreadLoginUser() {
		currentLoginUser.remove();
	}

	/**
	 * 基于Redis的实现，保存到缓存（使用默认过期时间）
	 */
	public void saveToCache(String name, Serializable value) {
		redisBaseDao.saveObject(name, value);
	}

	/**
	 * 基于Redis的实现，保存到缓存（指定过期时间）
	 */
	public void saveToCache(String name, Serializable value, int seconds) {
		redisBaseDao.saveObject(name, value, seconds);
	}

	/**
	 * 基于Redis的实现，保存到缓存
	 */
	public void saveSessionUser(UserVO userVO, int seconds) {
		if (null == userVO) {
			return;
		}
		String token = userVO.getToken();
		String key = SESSION_USERVO_KEY_PREFIX + token;
		if (seconds > 0) {
			saveToCache(key, userVO, seconds);
		}
		else {
			saveToCache(key, userVO);
		}
	}

	/**
	 * 基于Redis的实现，从Cache获取对象
	 */
	public Object getFromCache(String name) {
		return redisBaseDao.getObject(name);
	}
}
