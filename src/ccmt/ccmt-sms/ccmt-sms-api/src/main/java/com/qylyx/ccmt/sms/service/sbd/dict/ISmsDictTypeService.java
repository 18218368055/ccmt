package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.List;

import com.qylyx.ccmt.sms.entity.sbd.dict.co.SmsDictTypeListCo;
import com.qylyx.ccmt.sms.entity.sbd.dict.dto.SmsDictTypeDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictTypeVO;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

/**
 * 数据字典类型service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsDictTypeService {
	
	/**
	 * 获取系统使用的数据字典
	 * @return
	 */
	public Result<List<SmsDictTypeDto>> querySysUseDict();
	
	/**
	 * 查询列表
	 * @param pageCo 分页参数
	 * @param co 条件
	 * @return
	 */
	public Result<Page<SmsDictTypeVO>> queryList(PageCo pageCo, SmsDictTypeListCo co);
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	public Result<SmsDictTypeVO> add(SmsDictTypeVO vo);
}
