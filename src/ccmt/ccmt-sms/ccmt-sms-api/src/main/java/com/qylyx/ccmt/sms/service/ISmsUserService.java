package com.qylyx.ccmt.sms.service;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.remex.framework.base.entity.result.Result;

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
	public Result<SmsUserVO> login(String username);
}
