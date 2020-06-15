package com.bdqn.mapper;

import java.math.BigDecimal;
import java.util.Date;

public class AppInfo {
    /**
     * //主键id
     */
    private Long id;
    /**
     * //软件名称
     */
    private String softwareName;
    /**
     * //APK名称
     */
    private String apkName;

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom;
    }

    /**
     * //支持ROM
     */
    private String supportRom;
    /**
     * //界面语言
     */
    private String interfaceLanguage;
    /**
     * //更新日期
     */
    private Date updateDate;
    /**
     * //软件大小（单位：M）
     */
    private BigDecimal softwareSize;
    /**
     * //开发者id
     */
    private Long devId;
    /**
     * //应用简介
     */
    private String appInfo;
    /**
     * //app状态id
     */
    private Long status;
    /**
     * //上架时间
     */
    private Date onSaleDate;
    /**
     * //下架时间
     */
    private Date offSaleDate;
    /**
     * //所属三级分类id
     */
    private Long categoryLevel3;
    /**
     * //下载量（单位：次）
     */
    private Long downloads;
    /**
     * //app所属平台id
     */
    private Long flatformId;
    /**
     * //创建者
     */
    private Long createdBy;
    /**
     * //创建时间
     */
    private Date creationDate;
    /**
     * //更新者
     */
    private Long modifyBy;
    /**
     * //更新时间
     */
    private Date modifyDate;
    /**
     * //app状态名称
     */
    private String statusName;
    /**
     * /app所属平台名称
     */
    private String flatformName;
    private String categoryLevel3Name;//所属三级分类名称
    private String devName;//开发者名称

    private Long categoryLevel1;//所属一级分类id
    private Long categoryLevel2;//所属二级分类id
    private String categoryLevel1Name;//所属一级分类名称
    private String categoryLevel2Name;//所属二级分类名称

    private String logoPicPath;//LOGO图片URL路径
    private String logoLocPath;//LOGO图片的服务器存储路径

    private Long versionId;//最新的版本id
    private String versionNo;//最新的版本号

    public String getVersionNo() {
        return versionNo;
    }
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
    public Long getVersionId() {
        return versionId;
    }
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
    public String getLogoLocPath() {
        return logoLocPath;
    }
    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }
    public String getLogoPicPath() {
        return logoPicPath;
    }
    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }
    public Long getCategoryLevel3() {
        return categoryLevel3;
    }
    public void setCategoryLevel3(Long categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }
    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }
    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }
    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }
    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }
    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }
    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }
    public Long getCategoryLevel1() {
        return categoryLevel1;
    }
    public void setCategoryLevel1(Long categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }
    public Long getCategoryLevel2() {
        return categoryLevel2;
    }
    public void setCategoryLevel2(Long categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }
    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    public String getFlatformName() {
        return flatformName;
    }
    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    public String getDevName() {
        return devName;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSoftwareName() {
        return softwareName;
    }
    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }
    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }
    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }
    public Long getDevId() {
        return devId;
    }
    public void setDevId(Long devId) {
        this.devId = devId;
    }
    public String getAppInfo() {
        return appInfo;
    }
    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }
    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    public Date getOnSaleDate() {
        return onSaleDate;
    }
    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }
    public Date getOffSaleDate() {
        return offSaleDate;
    }
    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getDownloads() {
        return downloads;
    }
    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }
    public Long getFlatformId() {
        return flatformId;
    }
    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
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

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwareName='" + softwareName + '\'' +
                ", apkName='" + apkName + '\'' +
                ", supportRom='" + supportRom + '\'' +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                ", updateDate=" + updateDate +
                ", softwareSize=" + softwareSize +
                ", devId=" + devId +
                ", appInfo='" + appInfo + '\'' +
                ", status=" + status +
                ", onSaleDate=" + onSaleDate +
                ", offSaleDate=" + offSaleDate +
                ", categoryLevel3=" + categoryLevel3 +
                ", downloads=" + downloads +
                ", flatformId=" + flatformId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", statusName='" + statusName + '\'' +
                ", flatformName='" + flatformName + '\'' +
                ", categoryLevel3Name='" + categoryLevel3Name + '\'' +
                ", devName='" + devName + '\'' +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", categoryLevel1Name='" + categoryLevel1Name + '\'' +
                ", categoryLevel2Name='" + categoryLevel2Name + '\'' +
                ", logoPicPath='" + logoPicPath + '\'' +
                ", logoLocPath='" + logoLocPath + '\'' +
                ", versionId=" + versionId +
                ", versionNo='" + versionNo + '\'' +
                '}';
    }
}