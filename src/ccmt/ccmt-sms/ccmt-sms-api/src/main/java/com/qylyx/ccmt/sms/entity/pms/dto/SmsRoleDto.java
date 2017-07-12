package com.qylyx.ccmt.sms.entity.pms.dto;

import java.util.List;

import com.qylyx.ccmt.sms.entity.pms.vo.SmsRoleVO;

/**
 * 角色业务实体
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsRoleDto extends SmsRoleVO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否已被分配了
	 */
	private Boolean checked = false;
	
	/**
	 * 子角色列表
	 */
	private List<SmsRoleDto> children;
	
	public void setChildren(List<SmsRoleDto> children) {
		this.children = children;
	}
	
	public List<SmsRoleDto> getChildren() {
		return children;
	}
	
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	public Boolean getChecked() {
		return checked;
	}
}
