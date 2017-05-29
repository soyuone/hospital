package com.song.hospital.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 */
public class CookieUtil {

	/**
	 * 获取cookie的值
	 *
	 * @param request
	 * @param name cookie的名称
	 * @return cookie的值
	 */
	public static String getCookie(HttpServletRequest request, String name) {

		Map<String, String> cookieMap = getCookies(request);

		String value = cookieMap.get(name);

		return value;
	}

	/**
	 * 设置cookie，指定名称及值
	 *
	 * @param response
	 * @param name cookie的名称
	 * @param value cookie的值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {

		Cookie cookie = new Cookie(name, value);

		cookie.setMaxAge(IConstant.HOSPITAL_COOKIE_MAXAGE);
		cookie.setPath("/hospital/");

		response.addCookie(cookie);
	}

	/**
	 * 从request中获取cookie
	 *
	 * @param request
	 * @return cookie集合
	 */
	public static Map<String, String> getCookies(HttpServletRequest request) {

		Map<String, String> cookieMap = new HashMap<String, String>();

		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			return cookieMap;
		}

		for (Cookie cookie : cookies) {

			String name = cookie.getName();
			String value = cookie.getValue();

			name = name.trim();
			value = value.trim();
			cookieMap.put(name, value);
		}

		return cookieMap;
	}

	/**
	 * 设置用户cookie
	 *
	 * @param response
	 * @param token cookie的值
	 */
	public static void setUserTokenCookie(HttpServletResponse response, String token) {

		Cookie cookie = new Cookie(IConstant.HOSPITAL_COOKIE_TOKEN, token);

		// 设置可以访问该cookie的域名，域名格式由RFC 2109指定，必须由“.”开始，例如，设置.foo.com时，www.foo.com可以访问cookie，而a.b.foo.com不可以
		// cookie.setDomain(".");

		// 设置可以访问cookie的路径，指定路径及其子路径下的页面都可以访问
		cookie.setPath("/hospital/");
		// 设置cookie的最大存活时间（秒），正值表示*秒后cookie失效，负值表示cookie并非持久存储，当浏览器关闭时即删除，零值表示删除改cookie
		cookie.setMaxAge(IConstant.HOSPITAL_COOKIE_MAXAGE);
		// cookie是否仅在使用安全的协议时才发送给服务器，例如，https、ssl等协议
		cookie.setSecure(false);
		// cookie的用处说明，浏览器显示cookie信息时显示该说明
		cookie.setComment("for hospital project, store user's information.");
		// cookie使用的版本号
		cookie.setVersion(0);

		response.addCookie(cookie);
	}

	/**
	 * 获取用户cookie的值
	 *
	 * @param request
	 * @return cookie的值
	 */
	public static String getUserToken(HttpServletRequest request) {

		String value = getCookie(request, IConstant.HOSPITAL_COOKIE_TOKEN);

		return value;
	}

	/**
	 * 删除cookie，清除redis中的值
	 *
	 * @param request
	 * @param response
	 */
	public void expireUserTokenCookie(HttpServletRequest request, HttpServletResponse response) {

		String token = getUserToken(request);

		Cookie cookie = new Cookie(IConstant.HOSPITAL_COOKIE_TOKEN, token);

		cookie.setMaxAge(-1);
		cookie.setPath("/");

		response.addCookie(cookie);
	}
}
