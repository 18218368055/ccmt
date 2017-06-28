package com.qylyx.ccmt.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
