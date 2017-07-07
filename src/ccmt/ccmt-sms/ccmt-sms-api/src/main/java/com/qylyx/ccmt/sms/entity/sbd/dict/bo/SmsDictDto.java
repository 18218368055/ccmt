package com.qylyx.ccmt.sms.entity.sbd.dict.bo;

import java.io.Serializable;

/**
 * 供系统使用的数据字典
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsDictDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典代码
	 */
	private String code;
	
	/**
	 * 字典名称
	 */
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SmsDictDto [code=" + code + ", name=" + name + "]";
	}
	
	
}
