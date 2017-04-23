package com.song.hospital.common.util;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 */
public class JsonUtil {

	/**
	 * 将对象转换为json字符串
	 * 
	 * @param bean 可以是object或者数组
	 * @return json字符串
	 */
	public static String getJsonData(Object bean) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(bean);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将json字符串转化为bean对象
	 * 
	 * @param <T>
	 * @param jsonStr json字符串
	 * @param clazz bean对象格式
	 * @return bean对象
	 */
	public static <T> T jsonStringToBean(String jsonStr, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonStr, clazz);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将json字符串转化为list对象
	 * 
	 * @param <T>
	 * @param jsonArrStr json字符串
	 * @param clazz list中对象类型
	 * @return list对象
	 */
	public static <T> List<T> jsonStringToList(String jsonArrStr, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
			return mapper.readValue(jsonArrStr, javaType);
		}
		catch (Exception e) {
			return null;
		}
	}
}
