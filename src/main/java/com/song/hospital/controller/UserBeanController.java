package com.song.hospital.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.hospital.entity.UserBean;
import com.song.hospital.service.UserBeanService;

/**
 * <p>
 * Title: blogstation_[子系统名称]_[UserController]
 * </p>
 * <p>
 * Description: [UserController]
 * </p>
 * 
 * @author songyushi
 * @version $Revision$ 2017年2月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/user")
public class UserBeanController {

/*	protected Logger log = Logger.getLogger(UserBeanController.class);
*/
	@Autowired
	private UserBeanService userService;

	/**
	 * <p>
	 * Description:[添加用户-传统方式]
	 * </p>
	 * Created by [songyushi] [2017年2月17日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertuser/tradition", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertUserTradition(HttpServletRequest request) {
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
/*			log.error(e.getLocalizedMessage(), e);
*/			resultMap.put("code", 500);
			resultMap.put("result", "使用传统方式添加用户异常，可能是网络原因");
		}
		return resultMap;
	}

	/**
	 * <p>
	 * Description:[添加用户-注解方式]
	 * </p>
	 * Created by [songyushi] [2017年2月17日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertuser/annotation", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertUserUserAnnotation(HttpServletRequest request) {
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
/*			log.error(e.getLocalizedMessage(), e);
*/			resultMap.put("code", 500);
			resultMap.put("result", "使用注解方式添加用户异常，可能是网络原因");
		}
		return resultMap;
	}
}
