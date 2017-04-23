package com.song.hospital.service;

import java.util.Map;

import com.song.hospital.entity.UserBean;

/**
 * <p>
 * Title: hospital_[子系统名称]_[用户模块]
 * </p>
 * <p>
 * Description: [User Service]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年4月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface UserService {

	/**
	 * <p>
	 * Description:[添加用户-传统方式]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> insertUserTradition(UserBean user) throws Exception;

	/**
	 * <p>
	 * Description:[添加用户-注解方式]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> insertUserUserAnnotation(UserBean user) throws Exception;

}
