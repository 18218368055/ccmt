package com.qylyx.ccmt.sms.service.pms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.pms.ISmsRoleDao;
import com.qylyx.ccmt.sms.entity.pms.dto.SmsRoleDto;
import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.july.utils.tolerant.TolerantUtils;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;

/**
 * 角色管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("角色管理service")
@Service
public class SmsRoleService implements ISmsRoleService{
	
	@Autowired
	ISmsRoleDao smsRoleDao; 
	
	/**
	 * 查询所有的角色列表
	 * @return
	 */
	@Salog("查询所有的角色列表")
	@Override
	public Result<List<SmsRoleDto>> queryDtoList() {
		List<SmsRoleDto> list = handleRoleDtoList(smsRoleDao.queryDtoList());
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
			throw new RemexServiceException("301", "数据对象不能为空！");
		if (StringUtils.isBlank(vo.getName()))
			throw new RemexServiceException("302", "角色名称不能为空！");
		if (vo.getParentId() == null)
			throw new RemexServiceException("303", "父ID不能为空！");
		if (StringUtils.isBlank(vo.getStatus()))
			throw new RemexServiceException("304", "状态不能为空！");
		
		vo.setCreateTime(new Date());
		vo.setCreator("admin");
		vo.setModifyTime(new Date());
		vo.setModifier("admin");
		
		int count = smsRoleDao.save(vo);
		if (count == 0)
			throw new RemexServiceException("401", "受影响行数为0！");
		
		return new Result<SmsRoleVO>(vo);
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
		
		int count = smsRoleDao.changeStatus(id, status);
		if (count == 0)
			throw new RemexServiceException("301", "受影响行数为空！");
		
		return new Result<Void>(null);
	}
	
	/**
	 * 查询某用户的角色列表
	 * @param userId 用户id
	 * @return
	 */
	@Salog("查询某用户的角色列表")
	@Override
	public Result<List<SmsRoleDto>> queryUserRoleList(Long userId) {
		if (userId == null)
			throw new RemexServiceException("", "用户id不能为空！");
		
		List<SmsRoleDto> list = handleRoleDtoList(smsRoleDao.queryUserRoleList(userId));
		return new Result<List<SmsRoleDto>>(list);
	}

	/**
	 * 角色分配
	 * @param userId 用户id
	 * @param roleIds 角色id集合，以,号隔开
	 * @return
	 */
	@Salog("角色分配")
	@Override
	public Result<Void> distribute(Long userId, String roleIds) {
		if (userId == null)
			throw new RemexServiceException("", "用户id不能为空！");
		
		//分解角色id集合
		Set<Long> roleIdSet = new HashSet<Long>();
		String[] idArr = roleIds.split(",");
		for (String id : idArr) {
			if (StringUtils.isBlank(id))
				throw new RemexServiceException("", "角色id中存在空字符串的情况！");
			roleIdSet.add(Long.valueOf(id.trim()));
		}
		
		//先删除该用户下的所有已分配的角色
		smsRoleDao.deleteUserRoleIds(userId);
		//再重新插入新的角色
		smsRoleDao.distributeRole(userId, roleIdSet);
		
		return new Result<Void>(null);
	}
	
	/**
	 * 处理角色列表信息
	 * @param allList
	 * @return
	 */
	private List<SmsRoleDto> handleRoleDtoList(List<SmsRoleDto> allList) {
		allList = TolerantUtils.defaultList(allList);
		List<SmsRoleDto> list = new ArrayList<SmsRoleDto>();
		for (SmsRoleDto dto : allList) {
			if (SmsRoleVO.ROLE_ROOT_ID.equals(dto.getParentId())) {
				//递归封装父子级列表
				packChildDtoList(dto, allList);
				list.add(dto);
			}
		}
		return allList;
	}
	
	
	/**
	 * 递归封装角色父子级列表
	 */
	private void packChildDtoList(SmsRoleDto curDto, List<SmsRoleDto> allList) {
		List<SmsRoleDto> childList = new ArrayList<SmsRoleDto>();
		for (SmsRoleDto dto : allList) {
			if (curDto.getId().equals(dto.getParentId())) {
				//继续封装下一子级
				packChildDtoList(dto, allList);
				childList.add(dto);
			}
		}
		curDto.setChildren(childList);
	}

}
