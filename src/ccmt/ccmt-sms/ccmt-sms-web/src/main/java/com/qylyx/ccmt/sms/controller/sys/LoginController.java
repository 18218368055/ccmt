package com.qylyx.ccmt.sms.controller.sys;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.july.salog.annotation.Salog;

/**
 * 登录及相关的controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("登录及相关处理")
@Controller
@RequestMapping("/")
public class LoginController {
	/**
	 * 到登录界面
	 * @return
	 */
	@Salog("到登录界面")
	@RequestMapping("toLogin")
	public String toLogin() {
		return "sys/login";
	}
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpSession session, String username, String password) {
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			//登录成功的用户
			SmsUserVO user = (SmsUserVO) subject.getPrincipal();
			session.setAttribute("loginUser", user);
			return "redirect:index";
		} catch (Exception e) {
			return "redirect:toLogin";
		}
	}
}
