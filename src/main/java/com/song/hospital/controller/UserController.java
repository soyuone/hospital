package com.song.hospital.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.hospital.entity.UserBean;
import com.song.hospital.service.UserService;

/**
 * <p>
 * Title: hospital_[子系统名称]_[用户模块]
 * </p>
 * <p>
 * Description: [User Controller]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年4月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * <p>
	 * Description:[添加用户-传统方式]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register/tradition", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> registerByTradition(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String account = request.getParameter("account");
		try {
			// 添加
			UserBean user = new UserBean(username, password, Double.valueOf(account));
			resultMap = userService.insertUserTradition(user);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultMap.put("code", 500);
			resultMap.put("result", "使用传统方式添加用户异常，可能是网络原因");
		}
		return resultMap;
	}

	/**
	 * <p>
	 * Description:[添加用户-注解方式]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register/annotation", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> registerByAnnotation(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String account = request.getParameter("account");
		try {
			// 添加
			UserBean user = new UserBean(username, password, Double.valueOf(account));
			resultMap = userService.insertUserUserAnnotation(user);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultMap.put("code", 500);
			resultMap.put("result", "使用注解方式添加用户异常，可能是网络原因");
		}
		return resultMap;
	}
}
