package com.song.hospital.common.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session工具类
 */
public class SessionUtil {

	/**
	 * 获取session属性值
	 *
	 * @param request
	 * @param name 属性名
	 * @return 属性值
	 */
	public static Object getSessionAttribute(HttpServletRequest request, String name) {

		HttpSession session = request.getSession(true);

		return session.getAttribute(name);
	}

	/**
	 * 设置session属性
	 *
	 * @param request
	 * @param name 属性名
	 * @param value 属性值，可序列化的对象
	 */
	public static void setSessionAttribute(HttpServletRequest request, String name, Serializable value) {

		HttpSession session = request.getSession(true);

		session.setAttribute(name, value);
	}

	/**
	 * 获取session超时时间
	 *
	 * @param request
	 * @return 最大存活时间（秒）
	 */
	public static int getMaxInactiveInterval(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		return session.getMaxInactiveInterval();
	}

	/**
	 * 设置session超时时间
	 *
	 * @param request
	 * @param interval 最大存活时间（秒）
	 */
	public static void setSessionAliveTime(HttpServletRequest request, int interval) {

		HttpSession session = request.getSession(true);

		session.setMaxInactiveInterval(interval);
	}

	/**
	 * 获取session id
	 *
	 * @param request
	 * @return
	 */
	public static String getId(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		return session.getId();
	}

	/**
	 * 获取基于session id的key
	 *
	 * @param request
	 * @param oKey
	 * @return
	 */
	public static String getSessionKey(HttpServletRequest request, String oKey) {

		String sessionid = getId(request);

		String nKey = "session:" + sessionid + ":" + oKey;

		return nKey;
	}

	/**
	 * 获取session创建的时间，1/1/1970 GMT以来的毫秒
	 *
	 * @param request
	 * @return
	 */
	public static long getCreationTime(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		return session.getCreationTime();
	}

	/**
	 * 获取session的最后活跃时间，1/1/1970 GMT以来的毫秒
	 *
	 * @param request
	 * @return
	 */
	public static long getLastAccessedTime(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		return session.getLastAccessedTime();
	}

	/**
	 * 解除绑定至session的属性
	 *
	 * @param request
	 * @param name 属性名
	 */
	public static void removeAttribute(HttpServletRequest request, String name) {

		HttpSession session = request.getSession(true);

		session.removeAttribute(name);
	}

	/**
	 * 使session失效
	 *
	 * @param request
	 */
	public static void invalidate(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		session.invalidate();
	}
}
