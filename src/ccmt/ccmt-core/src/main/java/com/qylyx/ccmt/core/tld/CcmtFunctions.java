package com.qylyx.ccmt.core.tld;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import com.qylyx.ccmt.core.context.ApplicationContextUtils;
import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictTypeDto;
import com.qylyx.ccmt.sms.service.sbd.dict.ISmsDictTypeService;
import com.qylyx.july.utils.check.ValidateUtils;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.rconst.result.RemexResultConst;

/**
 * CCMT标签库
 * 
 * @author Qiaoxin.Hong
 *
 */
public class CcmtFunctions {
	
	/**
	 * 获取ApplicationContext
	 * @return
	 */
	private static ApplicationContext getContext() {
		return ApplicationContextUtils.getApplicationContext();
	}
	
	/**
	 * 数据字典翻译
	 * @param key
	 * @param code
	 * @return
	 */
	public static String dict(String key, String typeCode) {
		String value = null;
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(typeCode)) {
			List<SmsDictDto> dictList = dictGroup(typeCode);
			for (SmsDictDto dict : dictList) {
				if (key.equals(dict.getCode())) {
					value = dict.getName();
					break;
				}
			}
		}
		return StringUtils.defaultString(value);
	}
	
	/**
	 * 获取某一组数据字典
	 * @param typeCode 数据字典类型代码
	 * @return
	 */
	public static List<SmsDictDto> dictGroup(String typeCode) {
		List<SmsDictDto> dictList = null;
		if (StringUtils.isNotBlank(typeCode)) {
			ISmsDictTypeService smsDictTypeService = getContext().getBean(ISmsDictTypeService.class);
			if (smsDictTypeService != null) {
				Result<List<SmsDictTypeDto>> result = smsDictTypeService.queryHdDict();
				if (RemexResultConst.CODE_SUCCESS.equals(result.getCode())) {
					List<SmsDictTypeDto> typeList = result.getData();
					if (ValidateUtils.isNotEmpty(typeList)) {
						for (SmsDictTypeDto type : typeList) {
							if (typeCode.equals(type.getTypeCode())) {
								dictList = type.getDictList();
								break;
							}
						}
					}
				}
			}
		}
		if (dictList == null)
			dictList = new ArrayList<SmsDictDto>();
		return dictList;
	}
	
	
}
