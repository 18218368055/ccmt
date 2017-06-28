package com.qylyx.ccmt.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qylyx.ccmt.sms.service.ISmsUserService;

/**
 * 主controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private ISmsUserService smsUserService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		System.out.println("main index!!!!");
		return "index";
	}
}
