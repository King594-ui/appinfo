package com.bdqn.mapper;

import java.util.Date;

public class BackendUser {
    /**
    * 主键id
    */
    private Long id;

    /**
    * 用户编码
    */
    private String userCode;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
    */
    private Long usertype;

    /**
    * 创建者（来源于backend_user用户表的用户id）
    */
    private Long createdBy;

    /**
    * 创建时间
    */
    private Date creationDate;

    /**
    * 更新者（来源于backend_user用户表的用户id）
    */
    private Long modifyBy;

    /**
    * 最新更新时间
    */
    private Date modifyDate;

    /**
    * 用户密码
    */
    private String userPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUsertype() {
        return usertype;
    }

    public void setUsertype(Long usertype) {
        this.usertype = usertype;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}