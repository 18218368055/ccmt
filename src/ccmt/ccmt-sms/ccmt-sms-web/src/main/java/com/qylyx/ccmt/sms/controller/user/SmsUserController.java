package com.qylyx.ccmt.sms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.ISmsUserService;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

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
	
	@Autowired
	ISmsUserService smsUserService;
	
	/**
	 * 到用户列表界面
	 * @return
	 */
	@Salog("到用户列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/user/userList";
	}
	
	/**
	 * 查询用户列表
	 * @param pageCo
	 * @param co
	 * @return
	 */
	@Salog("查询用户列表")
	@RequestMapping("queryList")
	@ResponseBody
	public Object queryList(PageCo pageCo, SmsUserListCo co) {
		Page<SmsUserVO> page = smsUserService.queryUserList(pageCo, co).getData();
		return page;
	}
	
	/**
	 * 新增用户
	 * @param vo
	 * @return
	 */
	@Salog("新增用户")
	@RequestMapping("add")
	@ResponseBody
	public Object add(SmsUserVO vo) {
		System.out.println("add ====  " + JSONObject.toJSONString(vo));
		vo = smsUserService.add(vo).getData();
		return vo;
	}
}
