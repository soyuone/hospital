package com.song.hospital.service.impl;

import java.util.List;

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

	@Override
	public Integer countBy(UserBean user) throws Exception {
		return userMapper.countBy(user);
	}

	// 声明式事务管理，http://blog.csdn.net/bao19901210/article/details/41724355
	@Transactional
	@Override
	public Integer addUser(UserBean user) throws Exception {
		if (null == user) {
			return 0;
		}
		Integer num = userMapper.addUser(user);
		if (num <= 0) {
			throw new RuntimeException();
		}
		return num;
	}

	@Override
	public List<UserBean> getUserByParamMap(UserBean user) throws Exception {
		return userMapper.getUserByParamMap(user);
	}

}
