package com.qylyx.ccmt.sms.service.sbd.dict;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictTypeDto;
import com.qylyx.remex.base.entity.Result;

/**
 * 数据字典service
 * 
 * @author Qiaoxin.Hong
 *
 */
@Service
public class SmsDictService implements ISmsDictService {

	@Override
	public Result<List<SmsDictTypeDto>> queryHdDict() {
		List<SmsDictTypeDto> list = new ArrayList<SmsDictTypeDto>();
		SmsDictTypeDto type = new SmsDictTypeDto();
		type.setTypeCode("SMS_USER_STATUS");
		type.setTypeName("用户状态");
		List<SmsDictDto> dictList = new ArrayList<>();
		SmsDictDto dict = new SmsDictDto();
		dict.setCode("0");
		dict.setName("禁用");
		dictList.add(dict);
		SmsDictDto dict2 = new SmsDictDto();
		dict2.setCode("1");
		dict2.setName("启用");
		dictList.add(dict2);
		type.setDictList(dictList);
		list.add(type);
		return new Result<List<SmsDictTypeDto>>(list);
	}

}
