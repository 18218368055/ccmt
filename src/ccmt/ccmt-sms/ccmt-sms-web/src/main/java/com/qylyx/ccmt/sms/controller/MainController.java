package com.qylyx.ccmt.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.july.salog.annotation.Salog;

/**
 * 主controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	/**
	 * 首页
	 * @return
	 */
	@Salog("首页")
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@Salog("测试功能")
	@RequestMapping("test")
	@ResponseBody
	public Object test() {
		SmsUserVO user = new SmsUserVO();
		user.setName("测试人员");
		user.setUsername("test");
		return user;
	}
}
