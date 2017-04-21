package com.song.hospital.service;

import java.util.List;
import java.util.Map;

import com.song.hospital.entity.UserBean;

/**
 * <p>
 * Title: blogstation_[子系统名称]_[UserService]
 * </p>
 * <p>
 * Description: [UserService]
 * </p>
 * 
 * @author songyushi
 * @version $Revision$ 2017年2月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface UserBeanService {

	/**
	 * <p>
	 * Description:[添加用户-传统方式]
	 * </p>
	 * Created by [songyushi] [2017年2月17日] Midified by [修改人] [修改时间]
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
	 * Created by [songyushi] [2017年2月17日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> insertUserUserAnnotation(UserBean user) throws Exception;

}
