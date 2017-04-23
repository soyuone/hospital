package com.song.hospital.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CommonUtil {

	public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public final static String SHORT_DATE_FORMAT = "yyyy-MM-dd";

	public final static String NULL_STR = "";

	public final static String BLANK_STR = " ";

	public final static String SLASH_STR = "/";

	public static final String ENCODING_ISO8859 = "ISO-8859-1";

	public static final String ENCODING_ASCII = "ascii";

	public static final String ENCODING_UTF8 = "utf-8";

	public static final int SECONDS_A_DAY = 24 * 60 * 60;

	public static final int MILLISECONDS_A_DAY = SECONDS_A_DAY * 1000;

	public static final String ENVIRONMENT = "Environment";

	/**
	 * 功能描述：获取当前日期时间格式化字符串，默认yyyy-MM-dd HH:mm:ss格式
	 */
	public static String getCurrentDateTime() {
		return getCurrentDateTime(DEFAULT_DATE_FORMAT);
	}

	/**
	 * 功能描述：获取当前日期时间格式化字符串
	 * 
	 * @param dateFormat 日期时间格式
	 */
	public static String getCurrentDateTime(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述：随机获取6位纯数字
	 * 
	 * @param
	 */
	public static String getRandom() {
		int code = 0;
		while (code < 100000) {
			code = new Random().nextInt(999999);
		}
		;
		return String.valueOf(code);
	}

	public static String getOffsetDate(String startTime, int field, int offset) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(startTime));
			calendar.roll(field, offset);
			String offsetTime = sdf.format(calendar.getTime());
			return offsetTime;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* 生成32位的UUID */
	public static String generateId() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		id = id.replaceAll("-", "");
		return id;
	}

	public static String generateCode() {
		Random random = new Random();
		long i = random.nextInt();
		DecimalFormat df = new DecimalFormat("00000000");
		String id = df.format(i);
		return id;
	}

	public static String generateTimeCode() {
		Long time = new Date().getTime() / 1000L;
		return Long.toHexString(time);
	}
}
