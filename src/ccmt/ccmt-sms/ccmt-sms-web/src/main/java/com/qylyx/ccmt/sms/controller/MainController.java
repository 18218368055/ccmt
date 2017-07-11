package com.qylyx.ccmt.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qylyx.ccmt.sms.entity.sbd.dict.dto.SmsDictTypeDto;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.sbd.dict.ISmsDictTypeService;
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
	@Autowired
	ISmsDictTypeService smsDictTypeService;
	
	/**
	 * 首页
	 * @return
	 */
	@Salog("首页")
	@RequestMapping("index")
	public String index(Model model) {
		//数据字典
		List<SmsDictTypeDto> ccmtDictSource = smsDictTypeService.querySysUseDict().getData();
		model.addAttribute("ccmtDictSource", JSONObject.toJSON(ccmtDictSource));
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
