package com.qylyx.ccmt.sms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.user.ISmsUserService;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

/**
 * 用户管理controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("用户管理controller")
@Controller
@RequestMapping("/sms/user/")
public class SmsUserController {
	
	@Autowired
	ISmsUserService smsUserService;
	
	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/user/userList";
	}
	
	/**
	 * 查询列表
	 * @param pageCo
	 * @param co
	 * @return
	 */
	@Salog("查询列表")
	@RequestMapping("queryList")
	@ResponseBody
	public Object queryList(PageCo pageCo, SmsUserListCo co) {
		Page<SmsUserVO> page = smsUserService.queryUserList(pageCo, co).getDataWeb();
		return page;
	}
	
	/**
	 * 启用/禁用状态
	 * @return
	 */
	@Salog("启用/禁用状态")
	@RequestMapping("changeUserStatus")
	@ResponseBody
	public Object changeUserStatus(Long id, String status) {
		smsUserService.changeUserStatus(id, status);
		return null;
	}
}
