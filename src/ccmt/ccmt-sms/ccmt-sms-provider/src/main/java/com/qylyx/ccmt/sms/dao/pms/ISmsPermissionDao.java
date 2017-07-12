package com.qylyx.ccmt.sms.dao.pms;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsPermissionDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;

/**
 * 权限管理dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsPermissionDao {
	
	/**
	 * 查询系统所用的某用户的权限代码列表
	 * @param userId
	 * @return
	 */
	public Set<String> querySysUsePermissionList(Long userId);
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return 受影响的行数
	 */
	public int save(SmsPermissionVO vo);
	
	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int changeStatus(@Param("id") Long id, @Param("status") String status);
	
	/**
	 * 查询所有的权限列表
	 * @return
	 */
	public List<SmsPermissionDto> queryDtoList();
	
	/**
	 * 查询某角色的权限列表
	 * @param roleId 角色id
	 * @return
	 */
	public List<SmsPermissionDto> queryRolePermissionList(@Param("roleId") Long roleId);
	
	/**
	 * 删除某角色的所分配的所有权限
	 * @param roleId 角色id
	 * @return
	 */
	public int deleteRolePermissionIds(@Param("roleId") Long roleId);
	
	/**
	 * 批量分配用户角色
	 * @param roleId 角色id
	 * @param roleIds 权限id集合
	 * @return
	 */
	public int distributePermission(@Param("roleId") Long roleId, @Param("permissionIds") Set<Long> permissionIds);
}
