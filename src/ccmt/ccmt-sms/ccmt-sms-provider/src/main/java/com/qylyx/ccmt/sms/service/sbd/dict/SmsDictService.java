package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.dao.sbd.dict.ISmsDictDao;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictVO;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.service.exception.RemexServiceException;

/**
 * 数据字典service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("数据字典service")
@Service
public class SmsDictService implements ISmsDictService {
	
	@Autowired
	ISmsDictDao smsDictDao;

	/**
	 * 查询某组数据字典
	 * @param typeCode 数据字典类型代码
	 * @return
	 */
	@Salog("查询某组数据字典")
	@Override
	public Result<List<SmsDictVO>> queryList(String typeCode) {
		if (StringUtils.isBlank(typeCode))
			throw new RemexServiceException("301", "数据字典类型代码不能为空！");
		
		return new Result<>(smsDictDao.queryList(typeCode));
	}

	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@Override
	public Result<SmsDictVO> add(SmsDictVO vo) {
		if (vo == null)
			throw new RemexServiceException("301", "数据对象不能为空！");
		if (StringUtils.isBlank(vo.getTypeCode()))
			throw new RemexServiceException("302", "字典类型代码不能为空！");
		if (StringUtils.isBlank(vo.getCode()))
			throw new RemexServiceException("303", "字典代码不能为空！");
		if (StringUtils.isBlank(vo.getName()))
			throw new RemexServiceException("304", "字典名称不能为空！");
		
		vo.setCreateTime(new Date());
		vo.setCreator("admin");
		vo.setModifyTime(new Date());
		vo.setModifier("admin");
		int count = smsDictDao.save(vo);
		if (count == 0)
			throw new RemexServiceException("401", "数据保存异常，受影响行数为0！");
		return new Result<SmsDictVO>(vo);
	}

}
