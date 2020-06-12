package com.bdqn.mapper;

import java.util.Date;

public class AppCategory {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 分类编码
    */
    private String categoryCode;

    /**
    * 分类名称
    */
    private String categoryName;

    /**
    * 父级节点id
    */
    private Long parentId;

    /**
    * 创建者（来源于backend_user用户表的用户id）
    */
    private Long createdBy;

    /**
    * 创建时间
    */
    private Date creationTime;

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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