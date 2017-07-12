package com.qylyx.ccmt.sms.service.pms;

import java.util.List;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsRoleDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;
import com.qylyx.remex.base.entity.Result;

/**
 * 角色管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsRoleService {
	
	/**
	 * 查询所有的角色列表
	 * @return
	 */
	public Result<List<SmsRoleDto>> queryDtoList();
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	public Result<SmsRoleVO> add(SmsRoleVO vo);
	
	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	public Result<Void> changeStatus(Long id, String status);
	
	/**
	 * 查询某用户的角色列表
	 * @param userId 用户id
	 * @return
	 */
	public Result<List<SmsRoleDto>> queryUserRoleList(Long userId);
	
	/**
	 * 角色分配
	 * @param userId 用户id
	 * @param roleIds 角色id集合，以,号隔开
	 * @return
	 */
	public Result<Void> distribute(Long userId, String roleIds);
	
}
