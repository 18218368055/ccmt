package com.qylyx.ccmt.sms.service.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.user.SmsUserDao;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.ISmsUserService;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.framework.base.service.BaseService;
import com.qylyx.remex.iecup.entity.ResultEup;
import com.qylyx.remex.iecup.exception.RemexIecupException;

/**
 * 用户管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("用户管理")
@Service
public class SmsUserService extends BaseService implements ISmsUserService {
	
	@Autowired
	private SmsUserDao smsUserDao;

	/**
	 * 登录
	 * @param username 用户名
	 * @return
	 */
	@Salog("登录")
	@Override
	public ResultEup<SmsUserVO> login(String username) {
		if (StringUtils.isBlank(username))
			throw new RemexIecupException("301", "用户名不能为空！");
//		Long.valueOf("aa");
		SmsUserVO user = smsUserDao.login(username);
		return new ResultEup<SmsUserVO>(user);
	} 
}
