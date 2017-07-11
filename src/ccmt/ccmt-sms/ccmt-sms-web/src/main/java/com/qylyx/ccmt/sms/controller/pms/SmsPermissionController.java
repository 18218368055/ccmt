package com.qylyx.ccmt.sms.controller.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsPermissionDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;
import com.qylyx.ccmt.sms.service.pms.ISmsPermissionService;
import com.qylyx.july.salog.annotation.Salog;

/**
 * 权限管理controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("权限管理")
@RequestMapping("/sms/pms/permission/")
@Controller
public class SmsPermissionController {
	
	@Autowired
	ISmsPermissionService smsPermissionService;
	
	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/pms/permissionList";
	}
	
	/**
	 * 查询列表
	 * @return
	 */
	@Salog("查询列表")
	@RequestMapping("queryList")
	@ResponseBody
	public List<SmsPermissionDto> queryList() {
		List<SmsPermissionDto> list = smsPermissionService.queryDtoList().getDataWeb();
		return list;
	}
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@RequestMapping("add")
	@ResponseBody
	public Object add(SmsPermissionVO vo) {
		return "";
	}
}
