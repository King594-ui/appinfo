package com.bdqn.dao;

import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.DataDictionary;
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
}
