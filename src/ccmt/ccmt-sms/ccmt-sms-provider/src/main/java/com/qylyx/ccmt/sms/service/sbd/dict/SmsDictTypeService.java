package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.sbd.dict.ISmsDictTypeDao;
import com.qylyx.ccmt.sms.entity.sbd.dict.co.SmsDictTypeListCo;
import com.qylyx.ccmt.sms.entity.sbd.dict.dto.SmsDictTypeDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictTypeVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;
import com.qylyx.remex.framework.base.service.BaseService;

/**
 * 数据字典类型service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("数据字典类型service")
@Service
public class SmsDictTypeService extends BaseService implements ISmsDictTypeService {
	
	@Autowired
	ISmsDictTypeDao smsDictTypeDao;
	
	/**
	 * 获取系统使用的数据字典
	 * @return
	 */
	@Salog("获取系统使用的数据字典")
	@Override
	public Result<List<SmsDictTypeDto>> querySysUseDict() {
//		List<SmsDictTypeDto> list = smsDictTypeDao.queryHdDict();
		List<SmsDictTypeDto> list = new ArrayList<SmsDictTypeDto>();
		return new Result<List<SmsDictTypeDto>>(list);
	}

	/**
	 * 查询列表
	 * @param pageCo 分页参数
	 * @param co 条件
	 * @return
	 */
	@Salog("查询列表")
	@Override
	public Result<Page<SmsDictTypeVO>> queryList(PageCo pageCo, SmsDictTypeListCo co) {
		startPage(pageCo);
		List<SmsDictTypeVO> list = smsDictTypeDao.queryList(co);
		return packPage(list);
	}

	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@Override
	public Result<SmsDictTypeVO> add(SmsDictTypeVO vo) {
		if (vo == null)
			throw new RemexServiceException("301", "数据对象不能为空！");
		if (StringUtils.isBlank(vo.getTypeCode()))
			throw new RemexServiceException("302", "字典类型代码不能为空！");
		if (StringUtils.isBlank(vo.getTypeName()))
			throw new RemexServiceException("303", "字典类型名称不能为空！");
		
		vo.setCreateTime(new Date());
		vo.setCreator("admin");
		vo.setModifyTime(new Date());
		vo.setModifier("admin");
		int count = smsDictTypeDao.save(vo);
		if (count == 0)
			throw new RemexServiceException("401", "受影响行数为0！");
		return new Result<SmsDictTypeVO>(vo);
	}
}
