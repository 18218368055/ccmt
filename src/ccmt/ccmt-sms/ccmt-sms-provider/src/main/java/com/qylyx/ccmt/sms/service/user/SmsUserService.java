package com.qylyx.ccmt.sms.service.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.user.ISmsUserDao;
import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;
import com.qylyx.remex.framework.base.service.BaseService;

/**
 * 用户管理service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("用户管理service")
@Service
public class SmsUserService extends BaseService implements ISmsUserService {
	
	@Autowired
	private ISmsUserDao smsUserDao;
	
	/**
	 * 登录
	 * @param username 用户名
	 * @return
	 */
	@Salog("登录")
	@Override
	public Result<SmsUserVO> login(String username) {
		if (StringUtils.isBlank(username))
			throw new RemexServiceException("301", "用户名不能为空！");
		SmsUserVO user = smsUserDao.login(username);
		return new Result<SmsUserVO>(user);
	}

	/**
	 * 查询列表
	 * @param pageCo 分页参数
	 * @param co 条件
	 * @return
	 */
	@Salog("查询用户列表")
	@Cacheable("")
	@Override
	public Result<Page<SmsUserVO>> queryUserList(PageCo pageCo, SmsUserListCo co) {
		startPage(pageCo);
		List<SmsUserVO> list = smsUserDao.queryList(co);
		return packPage(list);
	}

	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	@Salog("启用/禁用用户状态")
	@Override
	public Result<Void> changeUserStatus(Long id, String status) {
		if (id == null)
			throw new RemexServiceException("301", "id不能为空！");
		if (StringUtils.isBlank(status))
			throw new RemexServiceException("302", "status不能为空！");
		
		int count = smsUserDao.changeStatus(id, status);
		if (count == 0)
			throw new RemexServiceException("301", "受影响行数为空！");
		
		return new Result<Void>(null);
	} 
}
