package com.qylyx.ccmt.sms.entity.pms.dto;

import java.util.List;

import com.qylyx.ccmt.sms.entity.pms.vo.SmsPermissionVO;

/**
 * 权限业务实体
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsPermissionDto extends SmsPermissionVO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 子权限列表
	 */
	private List<SmsPermissionDto> children;
	
	
	public void setChildren(List<SmsPermissionDto> children) {
		this.children = children;
	}
	
	public List<SmsPermissionDto> getChildren() {
		return children;
	}
}
