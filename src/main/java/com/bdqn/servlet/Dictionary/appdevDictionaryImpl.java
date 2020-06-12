package com.bdqn.servlet.Dictionary;

import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.dao.appdevuserdao;
import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.DataDictionary;

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

}
