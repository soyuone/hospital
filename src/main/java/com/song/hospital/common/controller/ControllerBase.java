package com.song.hospital.common.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.hospital.common.redis.RedisBaseDao;
import com.song.hospital.common.util.CookieUtil;
import com.song.hospital.common.util.IConstant;
import com.song.hospital.common.util.SessionUtil;
import com.song.hospital.vo.UserVO;

/**
 * spring mvc控制器层的基类
 */
public abstract class ControllerBase {

	protected Logger log = LoggerFactory.getLogger(ControllerBase.class);

	@Autowired
	protected RedisBaseDao redisBaseDao;

	// 创建线程本地变量
	// protected static final ThreadLocal<UserVO> currentLoginUser = new ThreadLocal<UserVO>();

	/**
	 * Removes the current thread's value for this thread-local variable.
	 */
	// public static void clearThreadLoginUser() {
	// currentLoginUser.remove();
	// }

	/**
	 * 基于Redis的实现，从Cache获取对象
	 */
	public Object getFromCache(String name) {
		return redisBaseDao.getObject(name);
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
		// token
		String token = userVO.getToken();
		// redis key
		String key = IConstant.SESSION_USERVO_TOKEN_PREFIX + token;
		// redis key有效期
		if (seconds > 0) {
			saveToCache(key, userVO, seconds);
		}
		else {
			saveToCache(key, userVO);
		}
	}

	/**
	 * 获取当前登录的用户
	 *
	 * @param request
	 * @return
	 */
	public UserVO getLoginUser(HttpServletRequest request) {
		if (null == request) {
			return null;
		}
		//
		UserVO userVO = new UserVO();
		// cookie
		String token = CookieUtil.getUserToken(request);
		if (null == token || token.trim().isEmpty()) {
			return null;
		}
		// redis key
		String key = IConstant.SESSION_USERVO_TOKEN_PREFIX + token;

		Object obj = redisBaseDao.getObject(key);
		//
		if (obj instanceof UserVO) {
			userVO = (UserVO) obj;
			SessionUtil.setSessionAttribute(request, IConstant.SESSION_USER_KEY, userVO);
			return userVO;
		}
		return null;
	}

}
