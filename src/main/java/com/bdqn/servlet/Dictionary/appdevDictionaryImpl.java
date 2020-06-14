package com.bdqn.servlet.Dictionary;

import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.AppVersion;
import com.bdqn.mapper.DataDictionary;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: APP状态实训接口
 * @date 2020-06-12 10:46
 */
public class appdevDictionaryImpl implements appdevDictionary{
    @Resource
    private appDataDictionaryColler appDataDictionaryColler;
    //开发app状态查询
    @Override
    public List<DataDictionary> getappcategorylist() {
        return appDataDictionaryColler.getappcategorylist();
    }

    @Override
    public List<DataDictionary> getappcategorylist1() {
        return appDataDictionaryColler.getappcategorylist1();
    }

    @Override
    public List<AppCategory> getappcategorylist2(String level,Long id) {
        return appDataDictionaryColler.getappcategorylist2(level,id);
    }

    @Override
    public List<AppCategory> getappcategorylist4(Long id) {
        return appDataDictionaryColler.getappcategorylist4(id);
    }

    @Override
    public int getappinfoAdd(AppInfo appInfo) {
        return appDataDictionaryColler.getappinfoAdd(appInfo);
    }

    @Override
    public int getapkname(String apkname) {
        return appDataDictionaryColler.getapkname(apkname);
    }

    @Override
    public int delapp(Long id) {
        return appDataDictionaryColler.delapp(id);
    }

    @Override
    public AppInfo appdevloperchaxun(Long id) {
        return appDataDictionaryColler.appdevloperchaxun(id);
    }

    @Override
    public List<AppVersion> getAppVersionList(Long appId) {
        return appDataDictionaryColler.getAppVersionList(appId);
    }
}
