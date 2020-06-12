package com.bdqn.mapper;

import java.util.Date;

public class AdPromotion {
    /**
    * 主键id
    */
    private Long id;

    /**
    * app_id（来源于：app_info表的主键id）
    */
    private Long appId;

    /**
    * 广告图片存储路径
    */
    private String adPicPath;

    /**
    * 广告点击量
    */
    private Long adPv;

    /**
    * 轮播位（1-n）
    */
    private Long carouselPosition;

    /**
    * 起效时间
    */
    private Date startTime;

    /**
    * 失效时间
    */
    private Date endTime;

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

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAdPicPath() {
        return adPicPath;
    }

    public void setAdPicPath(String adPicPath) {
        this.adPicPath = adPicPath;
    }

    public Long getAdPv() {
        return adPv;
    }

    public void setAdPv(Long adPv) {
        this.adPv = adPv;
    }

    public Long getCarouselPosition() {
        return carouselPosition;
    }

    public void setCarouselPosition(Long carouselPosition) {
        this.carouselPosition = carouselPosition;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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