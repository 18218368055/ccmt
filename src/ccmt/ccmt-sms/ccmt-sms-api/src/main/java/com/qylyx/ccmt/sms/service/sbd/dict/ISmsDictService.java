package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.List;

import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictVO;
import com.qylyx.remex.base.entity.Result;

/**
 * 数据字典service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsDictService {
	
	/**
	 * 查询某组数据字典
	 * @param typeCode 数据字典类型代码
	 * @return
	 */
	public Result<List<SmsDictVO>> queryList(String typeCode);
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	public Result<SmsDictVO> add(SmsDictVO vo);
}
