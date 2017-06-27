package com.qylyx.ccmt.sms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("index")
	public String index(@Value("${spring.mvc.view.prefix}") String string) {
		System.out.println("main index!!!!" + string);
		return "index";
	}
}
