package com.qylyx.ccmt.sms.dao.pms;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsRoleDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;

/**
 * 角色管理dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsRoleDao {
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return 受影响的行数
	 */
	public int save(SmsRoleVO vo);
	
	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int changeStatus(@Param("id") Long id, @Param("status") String status);
	
	/**
	 * 查询所有的角色列表
	 * @return
	 */
	public List<SmsRoleDto> queryDtoList();
	
	/**
	 * 查询某用户的角色列表
	 * @param userId 用户id
	 * @return
	 */
	public List<SmsRoleDto> queryUserRoleList(@Param("userId") Long userId);
	
	/**
	 * 删除某用户的所分配的所有角色
	 * @param userId
	 * @return
	 */
	public int deleteUserRoleIds(@Param("userId") Long userId);
	
	/**
	 * 批量分配用户角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public int distributeRole(@Param("userId") Long userId, @Param("roleIds") Set<Long> roleIds);
}
