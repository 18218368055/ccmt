package com.qylyx.ccmt.sms.controller.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsRoleDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;
import com.qylyx.ccmt.sms.service.pms.ISmsRoleService;
import com.qylyx.july.salog.annotation.Salog;

/**
 * 角色管理controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("角色管理")
@RequestMapping("/sms/pms/role/")
@Controller
public class SmsRoleController {
	
	@Autowired
	ISmsRoleService smsRoleService;

	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/pms/roleList";
	}
	
	/**
	 * 查询列表
	 * @return
	 */
	@Salog("查询列表")
	@RequestMapping("queryList")
	@ResponseBody
	public List<SmsRoleDto> queryList() {
		List<SmsRoleDto> list = smsRoleService.queryDtoList().getDataWeb();
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
	public Object add(SmsRoleVO vo) {
		smsRoleService.add(vo);
		return "";
	}
	
	
}
