package com.song.hospital.common.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * URI、URL及调试模式
 */
public class WebsiteConfig {

	public static boolean DEBUG_MODE = false;

	// 原始请求URI
	public static String KEY_ORIG_REQUEST_URI = "_ORIG_REQUEST_URI";

	// 原始请求URL
	public static String KEY_ORIG_REQUEST_URL = "_ORIG_REQUEST_URL";

	public static void init(Map<String, String> initOptions) {
		if (null == initOptions || initOptions.isEmpty()) {
			return;
		}
		// 获取调试模式
		String debugmodeStr = initOptions.get("debugmode");
		if (StringUtils.isNotBlank(debugmodeStr)) {
			boolean debugmode = Boolean.parseBoolean(debugmodeStr);
			DEBUG_MODE = debugmode;
		}
	}

	public static void ennableDebugMode() {
		DEBUG_MODE = true;
	}

	public static void disableDebugMode() {
		DEBUG_MODE = false;
	}

	public static boolean isDEBUG_MODE() {
		return DEBUG_MODE;
	}

}
