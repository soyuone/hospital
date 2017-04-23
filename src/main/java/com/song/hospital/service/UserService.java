package com.song.hospital.service;

import java.util.List;

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
	 * Description:[根据属性统计用户数量]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer countBy(UserBean user) throws Exception;

	/**
	 * <p>
	 * Description:[新增用户]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer addUser(UserBean user) throws Exception;

	/**
	 * <p>
	 * Description:[根据参数查询用户]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<UserBean> getUserByParamMap(UserBean user) throws Exception;

}
