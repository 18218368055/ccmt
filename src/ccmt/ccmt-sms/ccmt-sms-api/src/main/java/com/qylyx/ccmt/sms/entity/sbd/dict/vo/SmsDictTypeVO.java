package com.qylyx.ccmt.sms.entity.sbd.dict.vo;
/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.0.0
 */

import java.util.Date;

/**
 * 数据字典类型表(SMS_DICT_TYPE)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-09
 */
public class SmsDictTypeVO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -8204800342089629756L;

    /** 自增ID */
    private Long id;

    /** 字典类型代码 */
    private String typeCode;

    /** 字典类型名称 */
    private String typeName;

    /** 状态，0：禁用；1：启用 */
    private String status;

    /** 备注 */
    private String remark;

    /** 创建人 */
    private String creator;

    /** 创建时间 */
    private Date createTime;

    /** 修改人 */
    private String modifier;

    /** 修改时间 */
    private Date modifyTime;

    /**
     * 获取自增ID
     * 
     * @return 自增ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置自增ID
     * 
     * @param id
     *          自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字典类型代码
     * 
     * @return 字典类型代码
     */
    public String getTypeCode() {
        return this.typeCode;
    }

    /**
     * 设置字典类型代码
     * 
     * @param typeCode
     *          字典类型代码
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 获取字典类型名称
     * 
     * @return 字典类型名称
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * 设置字典类型名称
     * 
     * @param typeName
     *          字典类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取状态，0：禁用；1：启用
     * 
     * @return 状态
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置状态，0：禁用；1：启用
     * 
     * @param status
     *          状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置备注
     * 
     * @param remark
     *          备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     * 
     * @return 创建人
     */
    public String getCreator() {
        return this.creator;
    }

    /**
     * 设置创建人
     * 
     * @param creator
     *          创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime
     *          创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     * 
     * @return 修改人
     */
    public String getModifier() {
        return this.modifier;
    }

    /**
     * 设置修改人
     * 
     * @param modifier
     *          修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改时间
     * 
     * @return 修改时间
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 设置修改时间
     * 
     * @param modifyTime
     *          修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}