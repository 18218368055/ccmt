package com.qylyx.ccmt.sms.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
	
	private List<SmsUserVO> itemUserList = new ArrayList<SmsUserVO>();
	
	public SmsUserService() {
		Random random = new Random();
		for (int i = 0; i < 126; i++) {
			SmsUserVO user = new SmsUserVO();
			user.setId(1000L + i);
			user.setUsername("lu" + i);
			user.setName("路人甲" + i);
			user.setPassword("888888");
			user.setSex(random.nextInt(2));
			user.setBirthday(new Date());
			user.setStatus(random.nextInt(2));
			itemUserList.add(user);
		}
		itemUserList.get(0).setUsername("admin");
		itemUserList.get(0).setName("管理员");
	}

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
		
		SmsUserVO smsUserVO = null;
		for (SmsUserVO user : itemUserList) {
			if (username.equals(user.getUsername())) {
				smsUserVO = user;
				break;
			}
		}
		return new Result<SmsUserVO>(smsUserVO);
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
		int index = (int) ((pageCo.getPageNum() - 1) * pageCo.getPageSize());
		List<SmsUserVO> list = new ArrayList<SmsUserVO>();
		for (int i = index; i < index + 10; i++) {
			if (i > itemUserList.size() - 1)
				break;
			SmsUserVO user = itemUserList.get(i);
			list.add(user);
		}
		Page<SmsUserVO> page = createPage(pageCo);
		page.setData(list).setTotal(itemUserList.size() + 0L).setTotalPage(13L);
		return new Result<Page<SmsUserVO>>(page);
	}

	/**
	 * 新增用户
	 * @param vo 用户对象
	 * @return
	 */
	@Override
	public Result<SmsUserVO> add(SmsUserVO vo) {
		vo.setId(itemUserList.size() + 1001L);
		itemUserList.add(vo);
		return new Result<SmsUserVO>(vo);
	} 
}
