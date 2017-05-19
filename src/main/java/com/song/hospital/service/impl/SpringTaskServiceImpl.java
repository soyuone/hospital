package com.song.hospital.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.song.hospital.service.SpringTaskService;
import com.song.hospital.service.UserService;

/**
 * <p>
 * Title: hospital_[子系统名称]_[spring task]
 * </p>
 * <p>
 * Description: [spring task ServiceImpl]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年5月19日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("springTaskServiceImpl")
public class SpringTaskServiceImpl implements SpringTaskService {

	private Logger log = LoggerFactory.getLogger(SpringTaskServiceImpl.class);

	@Autowired
	private UserService userService;

	@Scheduled(cron = "0 0 9 * * ?")
	@Override
	public void springTaskAtMorning() {
		try {
			Integer userNum = userService.countBy(null);
			System.out.println("截止到今天09:00的用户数量为：" + userNum);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

	@Scheduled(cron = "0 15 9 ? * MON")
	@Override
	public void springTaskAtMonday() {
		try {
			Integer userNum = userService.countBy(null);
			System.out.println("截止到今天09:15的用户数量为：" + userNum);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

	@Scheduled(cron = "0 30 9 1 * ?")
	@Override
	public void springTaskAtMonth() {
		try {
			Integer userNum = userService.countBy(null);
			System.out.println("截止到今天09:30的用户数量为：" + userNum);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

}
