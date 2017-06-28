package com.qylyx.ccmt.sms.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.user.SmsUserDao;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.ISmsUserService;

@Service
public class SmsUserService implements ISmsUserService {

	@Autowired
	private SmsUserDao smsUserDao; 
}
