package com.song.hospital.common.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.song.hospital.common.util.IConstant;

/**
 * redis实现类
 */
@Repository("redisBaseDaoImpl")
public class RedisBaseDaoImpl implements RedisBaseDao {

	@Autowired
	protected RedisTemplate<String, Serializable> redisTemplate;

	// 给key加上前缀
	protected String prefixKey(String key) {
		return IConstant.NULL_STR + key;
	}

	@Override
	public boolean expire(String key, int seconds) {
		String _key = prefixKey(key);
		try {
			redisTemplate.expire(_key, seconds, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			redisTemplate.expire(_key, seconds, TimeUnit.SECONDS);
		}
		return true;
	}

	@Override
	public boolean saveObject(String key, Serializable value) {
		int seconds = IConstant.DEFAULT_EXPIRED_SECONDS;
		boolean result = saveObject(key, value, seconds);
		return result;
	}

	@Override
	public boolean saveObject(String key, Serializable value, int seconds) {
		boolean result = pureSaveObject(key, value);
		expire(key, seconds);
		return result;
	}

	public boolean pureSaveObject(String key, Serializable value) {
		String _key = prefixKey(key);
		try {
			redisTemplate.opsForValue().set(_key, value);
		}
		catch (Exception e) {
			redisTemplate.opsForValue().set(_key, value);
		}
		return true;
	}

	@Override
	public Object getObject(String key) {
		String _key = prefixKey(key);
		Object value = null;
		try {
			value = redisTemplate.opsForValue().get(_key);
		}
		catch (Exception e) {
			value = redisTemplate.opsForValue().get(_key);
		}
		return value;
	}

}
