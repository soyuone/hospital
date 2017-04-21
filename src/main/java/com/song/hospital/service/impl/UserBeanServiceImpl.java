package com.song.hospital.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.hospital.entity.UserBean;
import com.song.hospital.mapper.UserBeanMapper;
import com.song.hospital.service.UserBeanService;

/**
 * <p>
 * Title: blogstation_[子系统名称]_[UserServiceImpl]
 * </p>
 * <p>
 * Description: [UserServiceImpl]
 * </p>
 * 
 * @author songyushi
 * @version $Revision$ 2017年2月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("userBeanServiceImpl")
public class UserBeanServiceImpl implements UserBeanService {

	@Resource
	private UserBeanMapper um;

	@Transactional
	@Override
	public Map<String, Object> insertUserTradition(UserBean user) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (um.insertUserTradition(user) > 0) {
			// 人为制造异常，验证事务回滚
			int a = 2/0;
			resultMap.put("code", 200);
			resultMap.put("result", "使用传统方式添加用户成功");
		}
		else {
			resultMap.put("code", 500);
			resultMap.put("result", "使用传统方式添加用户失败");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> insertUserUserAnnotation(UserBean user) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (um.insertUserUserAnnotation(user) > 0) {
			// 人为制造异常，验证事务回滚
			// int a = 2/0;
			resultMap.put("code", 200);
			resultMap.put("result", "使用注解方式添加用户成功");
		}
		else {
			resultMap.put("code", 500);
			resultMap.put("result", "使用注解方式添加用户失败");
		}
		return resultMap;
	}

}
