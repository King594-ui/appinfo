package com.bdqn.servlet;

import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.BackendUser;
import com.bdqn.mapper.DevUser;

import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 用户
 * @date 2020-06-10 19:07
 */
public interface appdevUser {
    DevUser login(String devCode, String devPassword);
    BackendUser login1(String user_code,String user_password);
    //开发查询
    List<AppInfo> getAppinfoList();
}
