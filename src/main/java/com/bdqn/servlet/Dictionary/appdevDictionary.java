package com.bdqn.servlet.Dictionary;

import com.bdqn.mapper.AppCategory;
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
}
