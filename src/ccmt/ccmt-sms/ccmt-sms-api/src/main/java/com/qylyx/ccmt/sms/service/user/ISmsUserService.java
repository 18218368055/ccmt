package com.qylyx.ccmt.sms.service.user;

import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

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
	
	/**
	 * 查询用户列表
	 * @param co 查询条件
	 * @return
	 */
	public Result<Page<SmsUserVO>> queryUserList(PageCo pageCo, SmsUserListCo co);
	
	/**
	 * 新增用户
	 * @param vo 用户对象
	 * @return
	 */
	public Result<SmsUserVO> add(SmsUserVO vo);
	
	/**
	 * 修改用户
	 * @param vo
	 * @return
	 */
	public Result<SmsUserVO> update(SmsUserVO vo);
	
	/**
	 * 启用/禁用用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	public Result<Void> changeUserStatus(Long id, String status);
}
