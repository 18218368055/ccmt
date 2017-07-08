package com.qylyx.ccmt.sms.controller.sbd.dict;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qylyx.july.salog.annotation.Salog;

/**
 * 数据字典类型controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("数据字典类型管理")
@Controller
@RequestMapping("/sms/sbd/dict/")
public class SmsDictTypeController {
	
	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/sbd/dict/dictTypeList";
	}
}
