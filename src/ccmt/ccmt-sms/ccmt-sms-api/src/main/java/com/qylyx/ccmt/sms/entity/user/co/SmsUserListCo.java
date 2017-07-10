package com.qylyx.ccmt.sms.entity.user.co;

import java.io.Serializable;

/**
 * 用户列表查询条件
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsUserListCo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 用户名 */
    private String username;
    
    /** 名称 */
    private String name;
    
    /** 性别，0：男；1：女 */
    private String sex;
    
    /** 状态，0：禁用；1：启用 */
    private String status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SmsUserListCo [username=" + username + ", name=" + name
				+ ", sex=" + sex + ", status=" + status + "]";
	}
    
    
}
