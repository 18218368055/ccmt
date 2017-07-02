package com.qylyx.ccmt.sms.dao.user;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;

/**
 * 用户管理dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface SmsUserDao {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @return
	 */
	public SmsUserVO login(String username);
}
