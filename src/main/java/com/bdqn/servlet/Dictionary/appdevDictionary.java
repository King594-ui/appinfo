package com.bdqn.servlet.Dictionary;

import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppVersion;
import com.bdqn.mapper.DataDictionary;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.bdqn.mapper.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 啊桥哦
 * @Description: App状态查询
 * @date 2020-06-12 10:45
 */
public interface appdevDictionary {
    //开发app状态查询
    List<DataDictionary> getappcategorylist();
    //开发所属平台查询
    List<DataDictionary> getappcategorylist1();
    //开发一级分类
    List<AppCategory> getappcategorylist2(String level,Long id);
    //新增查询二级分类
    List<AppCategory> getappcategorylist4(Long id);
    //新增方法
     int getappinfoAdd(AppInfo appInfo);
    //apk查询是否重复
    int getapkname(String apkname);
    //删除方法
    int delapp( Long id);
    //查看方法
    AppInfo appdevloperchaxun(Long id);
    //查看版本方法
    List<AppVersion> getAppVersionList(Long appId);
    // //修改方法
    int  updateByPrimaryKeySelective(AppInfo appInfo);
    //查看版本方法
    AppVersion getappVersionUpdate( Long aid,Long vid);
    //查看旧版本方法
    List<AppVersion> getappVersionUpdate1(Long aid, Long vid);
    //删除apk文件
    int deleteapk(Long id);
    //新增版本方法
    int insertversion(AppVersion appVersion);
    //新增版本方法1
    int selectappversion();
    //新增版本方法2
    int updateappversions(Long id);
    //上下架
    int updateStatusById(Long id, String saleSwitch);
    //上下架1
    int updateStatusById1( Long id, String saleSwitch);
    //后台查看
    AppInfo appdevloperchaxun1( Long id);
}
