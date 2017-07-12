package com.qylyx.ccmt.sms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qylyx.ccmt.sms.entity.user.co.SmsUserListCo;
import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;

/**
 * 用户管理dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsUserDao {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @return
	 */
	public SmsUserVO login(String username);
	
	
	/**
	 * 查询列表
	 * @param co 条件
	 * @return
	 */
	public List<SmsUserVO> queryList(SmsUserListCo co);
	
	/**
	 * 新增
	 * @param vo
	 * @return
	 */
	public int save(SmsUserVO vo);
	
	/**
	 * 启用/禁用状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int changeStatus(@Param("id") Long id, @Param("status") String status);
}
