package com.qylyx.ccmt.sms.service.pms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.pms.ISmsPermissionDao;
import com.qylyx.ccmt.sms.entity.pms.dto.SmsPermissionDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.july.utils.tolerant.TolerantUtils;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;

/**
 * 权限管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("权限管理service")
@Service
public class SmsPermissionService implements ISmsPermissionService {
	
	@Autowired
	ISmsPermissionDao smsPermissionDao;

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
		
		Set<String> set = smsPermissionDao.querySysUsePermissionList(userId);
		return new Result<Set<String>>(set);
	}

	/**
	 * 查询所有的权限列表
	 * @return
	 */
	@Salog("查询所有的权限列表")
	@Override
	public Result<List<SmsPermissionDto>> queryDtoList() {
		List<SmsPermissionDto> list = handleRoleDtoList(smsPermissionDao.queryDtoList());
		return new Result<List<SmsPermissionDto>>(list);
	}

	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@Override
	public Result<SmsPermissionVO> add(SmsPermissionVO vo) {
		if (vo == null)
			throw new RemexServiceException("", "数据对象不能为空！");
		if (StringUtils.isBlank(vo.getName()))
			throw new RemexServiceException("302", "权限名称不能为空！");
		if (vo.getParentId() == null)
			throw new RemexServiceException("303", "父ID不能为空！");
		if (StringUtils.isBlank(vo.getStatus()))
			throw new RemexServiceException("304", "状态不能为空！");
		if (StringUtils.isBlank(vo.getCode()))
			throw new RemexServiceException("305", "权限代码不能为空！");
		
		
		vo.setCreateTime(new Date());
		vo.setCreator("admin");
		vo.setModifyTime(new Date());
		vo.setModifier("admin");
		
		int count = smsPermissionDao.save(vo);
		if (count == 0)
			throw new RemexServiceException("401", "受影响行数为0！");
		
		return new Result<SmsPermissionVO>(vo);
	}
	
	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	@Salog("启用/禁用用户状态")
	@Override
	public Result<Void> changeStatus(Long id, String status) {
		if (id == null)
			throw new RemexServiceException("301", "id不能为空！");
		if (StringUtils.isBlank(status))
			throw new RemexServiceException("302", "status不能为空！");
		
		int count = smsPermissionDao.changeStatus(id, status);
		if (count == 0)
			throw new RemexServiceException("301", "受影响行数为空！");
		
		return new Result<Void>(null);
	}

	/**
	 * 查询某角色的权限列表
	 * @param roleId 角色id
	 * @return
	 */
	@Salog("查询某角色的权限列表")
	@Override
	public Result<List<SmsPermissionDto>> queryRolePermissionList(Long roleId) {
		if (roleId == null)
			throw new RemexServiceException("", "角色id不能为空！");
		
		List<SmsPermissionDto> list = handleRoleDtoList(smsPermissionDao.queryRolePermissionList(roleId));
		return new Result<List<SmsPermissionDto>>(list);
	}

	/**
	 * 权限分配
	 * @param roleId 角色id
	 * @param permissionIds 权限id集合，以,号隔开
	 * @return
	 */
	@Salog("权限分配")
	@Override
	public Result<Void> distribute(Long roleId, String permissionIds) {
		if (roleId == null)
			throw new RemexServiceException("", "角色id不能为空！");
		
		Set<Long> permissionIdsIdSet = new HashSet<Long>();
		String[] idArr = permissionIds.split(",");
		for (String id : idArr) {
			if (StringUtils.isBlank(id))
				throw new RemexServiceException("", "权限id中存在空字符串的情况！");
			permissionIdsIdSet.add(Long.valueOf(id.trim()));
		}
		
		//先删除该角色下的所有已分配的权限
		smsPermissionDao.deleteRolePermissionIds(roleId);
		//再重新插入新的权限
		smsPermissionDao.distributePermission(roleId, permissionIdsIdSet);
		
		return new Result<Void>(null);
	}
	
	/**
	 * 处理权限列表信息
	 * @param allList
	 * @return
	 */
	private List<SmsPermissionDto> handleRoleDtoList(List<SmsPermissionDto> allList) {
		allList = TolerantUtils.defaultList(allList);
		List<SmsPermissionDto> list = new ArrayList<SmsPermissionDto>();
		for (SmsPermissionDto dto : allList) {
			if (SmsPermissionVO.PERMISSION_ROOT_ID.equals(dto.getParentId())) {
				//递归封装父子级列表
				packChildDtoList(dto, allList);
				list.add(dto);
			}
		}
		return allList;
	}
	
	
	/**
	 * 递归封装权限父子级列表
	 */
	private void packChildDtoList(SmsPermissionDto curDto, List<SmsPermissionDto> allList) {
		List<SmsPermissionDto> childList = new ArrayList<SmsPermissionDto>();
		for (SmsPermissionDto dto : allList) {
			if (curDto.getId().equals(dto.getParentId())) {
				//继续封装下一子级
				packChildDtoList(dto, allList);
				childList.add(dto);
			}
		}
		curDto.setChildren(childList);
	}

}
