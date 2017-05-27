package com.song.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.hospital.common.controller.ControllerBase;
import com.song.hospital.common.util.CommonUtil;
import com.song.hospital.common.util.CookieUtil;
import com.song.hospital.common.util.IConstant;
import com.song.hospital.common.util.MD5Util;
import com.song.hospital.common.util.ResultInfo;
import com.song.hospital.entity.UserBean;
import com.song.hospital.service.UserService;
import com.song.hospital.vo.UserVO;

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
public class UserController extends ControllerBase {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * <p>
	 * Description:[新增用户]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo register(HttpServletRequest request, HttpServletResponse response) {
		ResultInfo resultInfo = ResultInfo.newResultInfo();
		// 获取参数
		String email = request.getParameter("email");// Email
		String password = request.getParameter("password");// 登录密码

		// 空值校验
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
			resultInfo.setCode(IConstant.FAILED_DATA_NOINPUT);
			resultInfo.setMsg("参数错误");
			return resultInfo;
		}

		try {
			UserBean user = new UserBean();
			user.setEmail(email);

			// 检查该email是否已被注册
			if (userService.countBy(user) > 0) {
				resultInfo.setCode(IConstant.FAILURE);
				resultInfo.setMsg("该用户已注册");
				return resultInfo;
			}

			String passwordsalt = email;
			user.setUsername(CommonUtil.generateIdNoLine());
			user.setPasswordsalt(passwordsalt);// 密码盐
			user.setPassword(MD5Util.getSaltPassword(password, passwordsalt));// 密码加盐

			// 新增用户
			if (userService.addUser(user) > 0) {
				resultInfo.setCode(IConstant.SUCCESS);
				resultInfo.setMsg("注册成功");
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo.setCode(IConstant.FAILURE);
			resultInfo.setMsg("注册失败");
		}
		return resultInfo;
	}

	/**
	 * <p>
	 * Description:[登录]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo login(HttpServletRequest request, HttpServletResponse response) {
		ResultInfo resultInfo = ResultInfo.newResultInfo();
		// 获取参数
		String email = request.getParameter("email");// Email
		String password = request.getParameter("password");// 登录密码

		// 空值校验
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
			resultInfo.setCode(IConstant.FAILED_DATA_NOINPUT);
			resultInfo.setMsg("参数错误");
			return resultInfo;
		}

		try {
			UserBean user = new UserBean();
			user.setEmail(email);

			List<UserBean> userList = userService.getUserByParamMap(user);
			if (null != userList && userList.size() > 0) {
				UserBean userInfo = userList.get(0);
				String passwordInDB = userInfo.getPassword();
				String salt = userInfo.getPasswordsalt();

				String passwordInput = MD5Util.getSaltPassword(password, salt);
				if (null == passwordInDB) {
					resultInfo.setCode(IConstant.FAILURE);
					resultInfo.setMsg("用户信息不完整，请联系管理员");
				}
				else if (passwordInDB.equalsIgnoreCase(passwordInput)) {
					UserVO userVO = new UserVO();
					BeanUtils.copyProperties(userVO, userInfo);
					userVO.setToken(CommonUtil.generateId());

					// 使用spring-session把HttpSession放入Redis中
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("_USER_", userVO);
					// super.saveSessionUser(userVO, 7200);

					resultInfo.setCode(IConstant.SUCCESS);
					resultInfo.setMsg("登录成功");
				}
				else {
					resultInfo.setCode(IConstant.FAILURE);
					resultInfo.setMsg("密码错误");
				}
			}
			else {
				resultInfo.setCode(IConstant.FAILURE);
				resultInfo.setMsg("用户不存在");
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo.setCode(IConstant.FAILURE);
			resultInfo.setMsg("登录失败");
		}
		return resultInfo;
	}

	/**
	 * <p>
	 * Description:[登录，cookie方式]
	 * </p>
	 * Created by [SOYU] [2017年4月23日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login/cookie", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo loginByCookie(HttpServletRequest request, HttpServletResponse response) {
		ResultInfo resultInfo = ResultInfo.newResultInfo();
		// 获取参数
		String email = request.getParameter("email");// Email
		String password = request.getParameter("password");// 登录密码

		// 空值校验
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
			resultInfo.setCode(IConstant.FAILED_DATA_NOINPUT);
			resultInfo.setMsg("参数错误");
			return resultInfo;
		}

		try {
			UserBean user = new UserBean();
			user.setEmail(email);

			List<UserBean> userList = userService.getUserByParamMap(user);
			if (null != userList && userList.size() > 0) {
				UserBean userInfo = userList.get(0);
				String passwordInDB = userInfo.getPassword();
				String salt = userInfo.getPasswordsalt();

				String passwordInput = MD5Util.getSaltPassword(password, salt);
				if (null == passwordInDB) {
					resultInfo.setCode(IConstant.FAILURE);
					resultInfo.setMsg("用户信息不完整，请联系管理员");
				}
				else if (passwordInDB.equalsIgnoreCase(passwordInput)) {
					// 设置cookie
					CookieUtil.setCookie(response, IConstant.HOSPITAL_COOKIE_EMAIL, email);
					CookieUtil.setCookie(response, IConstant.HOSPITAL_COOKIE_PASSWORD, password);

					resultInfo.setCode(IConstant.SUCCESS);
					resultInfo.setMsg("登录成功");
				}
				else {
					resultInfo.setCode(IConstant.FAILURE);
					resultInfo.setMsg("密码错误");
				}
			}
			else {
				resultInfo.setCode(IConstant.FAILURE);
				resultInfo.setMsg("用户不存在");
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo.setCode(IConstant.FAILURE);
			resultInfo.setMsg("登录失败");
		}
		return resultInfo;
	}
}
