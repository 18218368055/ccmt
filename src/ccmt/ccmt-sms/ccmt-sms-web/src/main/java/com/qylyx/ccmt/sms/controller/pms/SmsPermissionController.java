package com.qylyx.ccmt.sms.controller.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Salog("权限管理controller")
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
		smsPermissionService.add(vo).getDataWeb();
		return null;
	}
	
	/**
	 * 启用/禁用状态
	 * @return
	 */
	@Salog("启用/禁用状态")
	@RequestMapping("changeStatus")
	@ResponseBody
	public Object changeStatus(Long id, String status) {
		smsPermissionService.changeStatus(id, status).getDataWeb();
		return null;
	}
	
	/**
	 * 到权限分配界面
	 * @param roleId 角色ID
	 * @return
	 */
	@Salog("到权限分配界面")
	@RequestMapping("toDistribute")
	public String toDistribute(Model model, Long roleId) {
		model.addAttribute("roleId", roleId);
		return "sms/pms/permissionDistribute";
	}
	
	/**
	 * 查询角色权限列表
	 * @return
	 */
	@Salog("查询角色权限列表")
	@RequestMapping("queryRolePermissionList")
	@ResponseBody
	public List<SmsPermissionDto> queryRolePermissionList(Long roleId) {
		List<SmsPermissionDto> list = smsPermissionService.queryRolePermissionList(roleId).getDataWeb();
		return list;
	}
	
	/**
	 * 权限分配
	 * @param roleId 角色id
	 * @param permissionIds 权限id集合，以,号隔开
	 * @return
	 */
	@Salog("权限分配")
	@RequestMapping("distribute")
	@ResponseBody
	public Object distribute(Long roleId, String permissionIds) {
		smsPermissionService.distribute(roleId, permissionIds).getDataWeb();
		return "";
	}
}
