package com.song.hospital.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.hospital.entity.UserBean;
import com.song.hospital.mapper.UserMapper;
import com.song.hospital.service.UserService;

/**
 * <p>
 * Title: hospital_[子系统名称]_[用户模块]
 * </p>
 * <p>
 * Description: [User ServiceImpl]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年4月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	@Transactional
	@Override
	public Map<String, Object> insertUserTradition(UserBean user) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (userMapper.insertUserTradition(user) > 0) {
			// 制造异常，验证事务回滚
			// int a = 2 / 0;
			resultMap.put("code", 200);
			resultMap.put("result", "使用传统方式添加用户成功");
		}
		else {
			throw new RuntimeException();
		}
		return resultMap;
	}

	@Transactional
	@Override
	public Map<String, Object> insertUserUserAnnotation(UserBean user) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (userMapper.insertUserUserAnnotation(user) > 0) {
			// 制造异常，验证事务回滚
			// int a = 2 / 0;
			resultMap.put("code", 200);
			resultMap.put("result", "使用注解方式添加用户成功");
		}
		else {
			throw new RuntimeException();
		}
		return resultMap;
	}
}
