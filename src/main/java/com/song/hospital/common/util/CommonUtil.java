package com.song.hospital.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * 常用工具类
 */
public class CommonUtil {

	/**
	 * 获取32位的UUID
	 *
	 * @return UUID
	 */
	public static String generateId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 获取32位的UUID，不含'-'
	 *
	 * @return UUID
	 */
	public static String generateIdNoLine() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		id = id.replaceAll("-", "");
		return id;
	}

	/**
	 * 随机获取6位纯数字，范围：100000~999999
	 *
	 * @return 伪随机数
	 */
	public static String getRandom() {
		int code = new Random().nextInt(900000) + 100000;
		return String.valueOf(code);
	}

}
