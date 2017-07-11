package com.qylyx.ccmt.sms.service.pms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.entity.pms.dto.SmsRoleDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;

/**
 * 角色管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("角色管理")
@Service
public class SmsRoleService implements ISmsRoleService{

	/**
	 * 查询所有的角色列表
	 * @return
	 */
	@Override
	public Result<List<SmsRoleDto>> queryDtoList() {
		List<SmsRoleDto> list = new ArrayList<SmsRoleDto>();
		for (int i = 0; i < 5; i++) {
			SmsRoleDto role = new SmsRoleDto();
			role.setId(0L + i);
			role.setName("aa" + i);
			role.setStatus("1");
			role.setRemark("aa");
			
			if (i%2 == 0) {
				List<SmsRoleDto> children = new ArrayList<SmsRoleDto>();
				for (int j = 0; j < 3; j++) {
					SmsRoleDto dto = new SmsRoleDto();
					dto.setId(0L + j);
					dto.setName("bb" + j);
					dto.setStatus("1");
					dto.setRemark("bb");
					children.add(dto);
				}
				role.setChildren(children);
			}
			list.add(role);
		}
		return new Result<List<SmsRoleDto>>(list);
	}

	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@Override
	public Result<SmsRoleVO> add(SmsRoleVO vo) {
		if (vo == null)
			throw new RemexServiceException("", "数据对象不能为空！");
		if (StringUtils.isBlank(vo.getName()))
			throw new RemexServiceException("", "角色名称不能为空！");
		if (vo.getParentId() == null)
			throw new RemexServiceException("", "父ID不能为空！");
		if (StringUtils.isBlank(vo.getStatus()))
			throw new RemexServiceException("", "状态不能为空！");
		
		vo.setId(1001L);
		
		return new Result<SmsRoleVO>(vo);
	}

	/**
	 * 角色分配
	 * @param userId 用户id
	 * @param roleIds 角色id集合，以,号隔开
	 * @return
	 */
	@Salog("角色分配")
	@Override
	public Result<String> distribute(Long userId, String roleIds) {
		if (userId == null)
			throw new RemexServiceException("", "用户id不能为空！");
		if (StringUtils.isBlank(roleIds))
			throw new RemexServiceException("", "角色id集合不能为空！");
		
		Set<Long> roleIdSet = new HashSet<Long>();
		String[] idArr = roleIds.split(",");
		for (String id : idArr) {
			if (StringUtils.isBlank(id))
				throw new RemexServiceException("", "角色id中存在空字符串的情况！");
			roleIdSet.add(Long.valueOf(id.trim()));
		}
		
		
		return new Result<String>("");
	}

}
