package com.song.hospital.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5工具类
 */
public class MD5Util {

	/**
	 * 此处可以循环N次，增加暴力破解的难度
	 *
	 * @param password 待加密文本
	 * @param salt 密码盐
	 * @return
	 */
	public static String getSaltPassword(String password, String salt) {

		String saltPassword = md5(password + salt);

		return saltPassword;
	}

	/**
	 * 对文本进行md5加密，此算法与 mysql、javascript生成的md5摘要进行过一致性对比
	 * 
	 * @param plainText 待加密文本
	 * @return 加密后的文本，返回值中的字母均为小写
	 */
	public static String md5(String plainText) {

		if (null == plainText) {
			plainText = "";
		}

		String MD5Str = "";
		try {
			// jdk 1.6 支持以下6种消息摘要算法（不区分大小写），md5、sha(sha-1)、md2、sha-256、sha-384、sha-512
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;
			StringBuilder builder = new StringBuilder(32);
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					builder.append("0");
				builder.append(Integer.toHexString(i));
			}
			MD5Str = builder.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return MD5Str;
	}

}
