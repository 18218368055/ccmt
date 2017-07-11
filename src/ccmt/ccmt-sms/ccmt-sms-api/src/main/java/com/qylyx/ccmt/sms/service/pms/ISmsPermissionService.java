package com.qylyx.ccmt.sms.service.pms;

import java.util.List;
import java.util.Set;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsPermissionDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;
import com.qylyx.remex.base.entity.Result;

/**
 * 权限管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsPermissionService {
	
	/**
	 * 查询系统所用的某用户的权限代码列表
	 * @param userId 用户ID
	 * @return 权限代码列表
	 */
	public Result<Set<String>> querySysUsePermissionList(Long userId);
	
	/**
	 * 查询所有的权限列表
	 * @return
	 */
	public Result<List<SmsPermissionDto>> queryDtoList();
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	public Result<SmsPermissionVO> add(SmsPermissionVO vo);
}
