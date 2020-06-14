package com.bdqn.dao;

import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.AppVersion;
import com.bdqn.mapper.DataDictionary;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 啊桥哦
 * @Description: APP状态查询
 * @date 2020-06-12 10:41
 */
public interface appDataDictionaryColler {
    //开发app状态查询
    List<DataDictionary> getappcategorylist();
    //开发所属平台查询
    List<DataDictionary> getappcategorylist1();
    //开发查询一级分类
    List<AppCategory> getappcategorylist2(@Param("level") String level,@Param("id") Long id);
    //开发查询二级分类
    List<AppCategory> categorylevellist(@Param("id") Long id);
    //新增查询开发列表
    List<DataDictionary> getappdatadictionlist(@Param("code") String code);
    //新增三级查询
    List<AppCategory> getappcategorylist4(@Param("id") long id);
    //新增方法
    int getappinfoAdd(AppInfo appInfo);
    //apk查询是否重复
    int getapkname(@Param("apkname") String apkname);
    //删除方法
    int delapp(@Param("id") Long id);
    //查看方法
    AppInfo appdevloperchaxun(@Param("id") Long id);
    //查看版本方法
    List<AppVersion> getAppVersionList(@Param("appId") Long appId);
}
