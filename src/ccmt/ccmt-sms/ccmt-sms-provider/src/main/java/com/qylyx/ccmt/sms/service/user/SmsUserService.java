package com.qylyx.ccmt.sms.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.user.SmsUserDao;
import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.ISmsUserService;
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
	public Result<SmsUserVO> login(String username) {
		if (StringUtils.isBlank(username))
			throw new RemexServiceException("301", "用户名不能为空！");
//		SmsUserVO user = smsUserDao.login(username);
		SmsUserVO user = new SmsUserVO();
		user.setUsername("admin");
		user.setName("管理员");
		user.setPassword("888888");
		return new Result<SmsUserVO>(user);
	}

	/**
	 * 查询用户列表
	 * @param co 查询条件
	 * @return
	 */
	@Override
	public Result<Page<SmsUserVO>> queryUserList(PageCo pageCo, SmsUserListCo co) {
		//验证分页条件
		validatePageCo(pageCo);
		
		List<SmsUserVO> list = new ArrayList<SmsUserVO>();
		for (int i = 0; i < 10; i++) {
			SmsUserVO user = new SmsUserVO();
			user.setId(1000L + i);
			user.setUsername("lu" + i);
			user.setName("路人甲" + i);
			user.setPassword("888888");
			list.add(user);
		}
		Page<SmsUserVO> page = createPage(pageCo);
		page.setData(list).setTotal(38L).setTotalPage(4L);
		return new Result<Page<SmsUserVO>>(page);
	}

	/**
	 * 新增用户
	 * @param vo 用户对象
	 * @return
	 */
	@Override
	public Result<SmsUserVO> add(SmsUserVO vo) {
		vo.setId(2001L);
		return new Result<SmsUserVO>(vo);
	} 
}
