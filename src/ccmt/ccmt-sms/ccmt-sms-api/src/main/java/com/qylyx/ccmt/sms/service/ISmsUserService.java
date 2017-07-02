package com.qylyx.ccmt.sms.service;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.remex.iecup.entity.ResultEup;

/**
 * 用户管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsUserService {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @return
	 */
	public ResultEup<SmsUserVO> login(String username);
}
