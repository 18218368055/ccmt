package com.qylyx.ccmt.sms.entity.sbd.dict.co;

import java.io.Serializable;

/**
 * 数据字典类型列表查询条件
 * 
 * @author Qiaoxin.Hong
 *
 */
public class SmsDictTypeListCo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 字典类型代码 */
    private String typeCode;
    
    /** 字典类型名称 */
    private String typeName;
    
    /** 状态，0：禁用；1：启用 */
    private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SmsDictTypeListCo [typeCode=" + typeCode + ", typeName="
				+ typeName + ", status=" + status + "]";
	}
    
    
}
