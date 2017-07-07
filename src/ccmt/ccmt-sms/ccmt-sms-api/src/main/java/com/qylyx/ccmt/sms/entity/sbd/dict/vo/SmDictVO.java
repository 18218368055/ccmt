/*
 * Welcome to use the TableToBean Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 *  
 * Author:bianj
 * Email:edinsker@163.com
 * Version:3.0.0
 */

package com.qylyx.ccmt.sms.entity.sbd.dict.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据字典表
 * 
 * @author Qiaoxin.Hong
 *
 */
@Entity
@Table(name = "SM_DICT")
public class SmDictVO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 4671950768227278491L;
    
    /** 主键 */
    @Id
    @Column(name = "ID")
    private Integer id;
    
    /** 字典代码 */
    @Column(name = "CODE")
    private String code;
    
    /** 字典名称 */
    @Column(name = "NAME")
    private String name;
    
    /** 字典类型代码 */
    @Column(name = "TYPE_CODE")
    private String typeCode;
    
    /** 字典类型名称 */
    @Column(name = "TYPE_NAME")
    private String typeName;
    
    /** 状态，0：禁用，1：启用 */
    @Column(name = "STATUS")
    private Integer status;
    
    /** 排序 */
    @Column(name = "SORT")
    private Integer sort;
    
    /** 备注 */
    @Column(name = "REMARK")
    private String remark;
    
    /** 创建人 */
    @Column(name = "CREATOR")
    private String creator;
    
    /** 创建时间 */
    @Column(name = "CREATE_TIME")
    private Date createTime;
    
    /** 修改人 */
    @Column(name = "MODIFIER")
    private String modifier;
    
    /** 修改时间 */
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;
    
    /**
     * 获取主键
     * 
     * @return 主键
     */
    public Integer getId() {
        return this.id;
    }
     
    /**
     * 设置主键
     * 
     * @param id
     *          主键
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * 获取字典代码
     * 
     * @return 字典代码
     */
    public String getCode() {
        return this.code;
    }
     
    /**
     * 设置字典代码
     * 
     * @param code
     *          字典代码
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * 获取字典名称
     * 
     * @return 字典名称
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置字典名称
     * 
     * @param name
     *          字典名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取状态，0：禁用，1：启用
     * 
     * @return 状态
     */
    public Integer getStatus() {
        return this.status;
    }
     
    /**
     * 设置状态，0：禁用，1：启用
     * 
     * @param status
     *          状态，0：禁用，1：启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * 获取排序
     * 
     * @return 排序
     */
    public Integer getSort() {
        return this.sort;
    }
     
    /**
     * 设置排序
     * 
     * @param sort
     *          排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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