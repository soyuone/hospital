package com.song.hospital.common.redis;

import java.io.Serializable;

/**
 * Redis工具类
 */
public interface RedisBaseDao {

	/**
	 * 设置过期时间
	 * 
	 * @param key 键
	 * @param seconds 过期时间
	 * @return
	 */
	public boolean expire(String key, int seconds);

	/**
	 * 保存对象
	 * 
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean saveObject(String key, Serializable value);

	/**
	 * 保存自动过期对象
	 * 
	 * @param key 键
	 * @param value 值
	 * @param seconds 过期时间
	 * @return
	 */
	public boolean saveObject(String key, Serializable value, int seconds);

	/**
	 * 获取对象
	 * 
	 * @param key 键
	 * @return
	 */
	public Object getObject(String key);

}
