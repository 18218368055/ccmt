package com.qylyx.ccmt.sms.controller.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/**
	 * 到角色分配界面
	 * @param userId 用户ID
	 * @return
	 */
	@Salog("到角色分配界面")
	@RequestMapping("toDistribute")
	public String toDistribute(Model model, Long userId) {
		model.addAttribute("userId", userId);
		return "sms/pms/roleDistribute";
	}
	
	/**
	 * 查询用户角色列表
	 * @return
	 */
	@Salog("查询用户角色列表")
	@RequestMapping("queryUserRoleList")
	@ResponseBody
	public List<SmsRoleDto> queryUserRoleList(Long userId) {
		List<SmsRoleDto> list = smsRoleService.queryDtoList().getDataWeb();
		return list;
	}
	
	/**
	 * 角色分配
	 * @param userId 用户id
	 * @param roleIds 角色id集合，以,号隔开
	 * @return
	 */
	@Salog("角色分配")
	@RequestMapping("distribute")
	@ResponseBody
	public Object distribute(Long userId, String roleIds) {
		smsRoleService.distribute(userId, roleIds).getDataWeb();
		return "";
	}
	
}
