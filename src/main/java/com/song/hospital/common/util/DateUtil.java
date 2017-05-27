package com.song.hospital.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期、时间工具类
 */
public class DateUtil {

	/**
	 * 获取当前日期的格式化字符串，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime() {
		return getCurrentDateTime(IConstant.DEFAULT_DATE_FORMAT);
	}

	/**
	 * 获取当前日期的格式化字符串，格式：自定义
	 */
	public static String getCurrentDateTime(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
	}
}
