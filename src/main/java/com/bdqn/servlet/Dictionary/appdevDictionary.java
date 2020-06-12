package com.bdqn.servlet.Dictionary;

import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.DataDictionary;

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
    //开发二级分类
//    List<AppCategory> getappcategorylist3();
}
