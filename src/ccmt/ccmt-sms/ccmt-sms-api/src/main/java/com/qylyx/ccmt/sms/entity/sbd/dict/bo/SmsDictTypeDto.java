package com.qylyx.ccmt.sms.entity.sbd.dict.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 供系统使用的数据字典类型
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsDictTypeDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 字典类型代码
	 */
	private String typeCode;
	
	/**
	 * 字典类型名称
	 */
	private String typeName;
	
	/**
	 * 数据字典列表
	 */
	private List<SmsDictDto> dictList;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<SmsDictDto> getDictList() {
		return dictList;
	}

	public void setDictList(List<SmsDictDto> dictList) {
		this.dictList = dictList;
	}

	@Override
	public String toString() {
		return "SmsDictTypeDto [typeCode=" + typeCode + ", typeName=" + typeName + ", dictList=" + dictList + "]";
	}
	
	
	
}
