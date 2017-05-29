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
	 * 获取基于session id的key
	 *
	 * @param request
	 * @param oKey
	 * @return
	 */
	public static String getSessionKey(HttpServletRequest request, String oKey) {
		// 获取session
		HttpSession session = request.getSession(true);
		// 获取session id
		String sessionid = session.getId();
		String nKey = "sessionid:" + sessionid + ":" + oKey;

		return nKey;
	}

}
