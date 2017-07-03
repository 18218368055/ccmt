package com.qylyx.ccmt.sms.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qylyx.july.salog.annotation.Salog;

/**
 * 用户管理con
 * troller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("用户管理")
@Controller
@RequestMapping("/sms/user/")
public class SmsUserController {
	
	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到用户列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/user/userList";
	}
}
