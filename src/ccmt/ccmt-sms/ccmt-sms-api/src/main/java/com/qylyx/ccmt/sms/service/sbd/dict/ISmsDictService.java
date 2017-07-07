package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.List;

import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictTypeDto;
import com.qylyx.remex.base.entity.Result;

/**
 * 数据字典service
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsDictService {
	
	/**
	 * 获取系统使用的数据字典
	 * @return
	 */
	public Result<List<SmsDictTypeDto>> queryHdDict();
}
