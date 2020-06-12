package com.bdqn.mapper;

import java.util.Date;

public class DevUser {
    /**
    * 主键id
    */
    private Long id;

    /**
    * 开发者帐号
    */
    private String devCode;

    /**
    * 开发者名称
    */
    private String devName;

    /**
    * 开发者密码
    */
    private String devPassword;

    /**
    * 开发者电子邮箱
    */
    private String devEmail;

    /**
    * 开发者简介
    */
    private String devInfo;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword;
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo;
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
}