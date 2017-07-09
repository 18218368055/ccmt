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

package com.qylyx.ccmt.sms.entity.user.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 * 
 * @author Qiaoxin.Hong
 *
 */
@Entity
@Table(name = "SMS_USER")
public class SmsUserVO2 implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2205668998937931974L;
    
    /** 主键 */
    @Id
    @Column(name = "ID")
    private Long id;
    
    /** 用户名 */
    @Column(name = "USERNAME")
    private String username;
    
    /** 密码 */
    @Column(name = "PASSWORD")
    private String password;
    
    /** 名称 */
    @Column(name = "NAME")
    private String name;
    
    /** 性别，0：男；1：女 */
    @Column(name = "SEX")
    private String sex;
    
    /** 生日 */
    @Column(name = "BIRTHDAY")
    private Date birthday;
    
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
    
    /** 状态，0：禁用；1：启用 */
    @Column(name = "STATUS")
    private String status;
    
    /**
     * 获取主键
     * 
     * @return 主键
     */
    public Long getId() {
        return this.id;
    }
     
    /**
     * 设置主键
     * 
     * @param id
     *          主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUsername() {
        return this.username;
    }
     
    /**
     * 设置用户名
     * 
     * @param username
     *          用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }
     
    /**
     * 设置密码
     * 
     * @param password
     *          密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 获取名称
     * 
     * @return 名称
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置名称
     * 
     * @param name
     *          名称
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取性别，0：男；1：女
     * 
     * @return 性别
     */
    public String getSex() {
        return this.sex;
    }
     
    /**
     * 设置性别，0：男；1：女
     * 
     * @param sex
     *          性别，0：男；1：女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    /**
     * 获取生日
     * 
     * @return 生日
     */
    public Date getBirthday() {
        return this.birthday;
    }
     
    /**
     * 设置生日
     * 
     * @param birthday
     *          生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     *          状态，0：禁用；1：启用
     */
    public void setStatus(String status) {
        this.status = status;
    }
}