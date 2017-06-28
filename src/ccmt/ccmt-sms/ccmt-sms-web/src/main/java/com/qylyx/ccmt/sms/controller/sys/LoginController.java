package com.qylyx.ccmt.sms.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
