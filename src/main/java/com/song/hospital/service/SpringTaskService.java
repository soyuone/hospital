package com.song.hospital.service;

/**
 * <p>
 * Title: hospital_[子系统名称]_[spring task]
 * </p>
 * <p>
 * Description: [spring task Service]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年5月19日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface SpringTaskService {

	/**
	 * <p>
	 * Description:[定时任务，每天早上09:00触发，查询用户数量]
	 * </p>
	 * Created by [SOYU] [2017年5月19日] Midified by [修改人] [修改时间]
	 */
	public void springTaskAtMorning();

	/**
	 * <p>
	 * Description:[定时任务，每周一09:15触发，查询用户数量]
	 * </p>
	 * Created by [SOYU] [2017年5月19日] Midified by [修改人] [修改时间]
	 */
	public void springTaskAtMonday();

	/**
	 * <p>
	 * Description:[定时任务，每月一号09:30触发，查询用户数量]
	 * </p>
	 * Created by [SOYU] [2017年5月19日] Midified by [修改人] [修改时间]
	 */
	public void springTaskAtMonth();

}
