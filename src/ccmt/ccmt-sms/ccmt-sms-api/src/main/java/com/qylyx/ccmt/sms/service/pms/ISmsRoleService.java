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
}
