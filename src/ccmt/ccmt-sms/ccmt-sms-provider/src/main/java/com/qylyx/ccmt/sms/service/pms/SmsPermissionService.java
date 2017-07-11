package com.qylyx.ccmt.sms.service.pms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsPermissionDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;

/**
 * 权限管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("权限管理")
@Service
public class SmsPermissionService implements ISmsPermissionService {

	/**
	 * 查询系统所用的某用户的权限代码列表
	 * @param userId 用户ID
	 * @return 权限代码列表
	 */
	@Salog("查询系统所用的某用户的权限代码列表")
	@Override
	public Result<Set<String>> querySysUsePermissionList(Long userId) {
		if (userId == null)
			throw new RemexServiceException("301", "用户ID不能为空！");
		
		Set<String> set = new HashSet<String>();
		set.add("/sms/sbd/dictType/toList");
		return new Result<Set<String>>(set);
	}

	/**
	 * 查询所有的权限列表
	 * @return
	 */
	@Override
	public Result<List<SmsPermissionDto>> queryDtoList() {
		List<SmsPermissionDto> list = new ArrayList<SmsPermissionDto>();
		for (int i = 0; i < 5; i++) {
			SmsPermissionDto role = new SmsPermissionDto();
			role.setId(0L + i);
			role.setName("aa" + i);
			role.setStatus("1");
			role.setRemark("aa");
			role.setCode("/sms/pms/permission/toList");
			role.setUrl("/sms/pms/permission/toList");
			
			if (i%2 == 0) {
				List<SmsPermissionDto> children = new ArrayList<SmsPermissionDto>();
				for (int j = 0; j < 3; j++) {
					SmsPermissionDto dto = new SmsPermissionDto();
					dto.setId(0L + j);
					dto.setName("bb" + j);
					dto.setStatus("1");
					dto.setRemark("bb");
					dto.setCode("/sms/pms/permission/toList");
					dto.setUrl("/sms/pms/permission/toList");
					children.add(dto);
				}
				role.setChildren(children);
			}
			list.add(role);
		}
		return new Result<List<SmsPermissionDto>>(list);
	}

	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Override
	public Result<SmsPermissionVO> add(SmsPermissionVO vo) {
		
		return new Result<SmsPermissionVO>(vo);
	}

}
