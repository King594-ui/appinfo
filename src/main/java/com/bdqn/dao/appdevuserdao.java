package com.bdqn.dao;

import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.BackendUser;
import com.bdqn.mapper.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 用户
 * @date 2020-06-10 19:44
 */

public interface appdevuserdao {
    //开发登陆
    DevUser login(@Param("devCode") String devCode, @Param("devPassword") String devPassword);
    //后台管理登陆
    BackendUser login1(@Param("user_code") String user_code, @Param("user_password") String user_password);
    //开发查询
    List<AppInfo> getAppinfoList(@Param("querySoftwareName") String querySoftwareName,
                                 @Param("queryStatus") Long queryStatus,
                                 @Param("queryFlatformId") Long queryFlatformId,
                                 @Param("queryCategoryLevel1") Long queryCategoryLevel1,
                                 @Param("queryCategoryLevel2") Long queryCategoryLevel2,
                                 @Param("queryCategoryLevel3") Long queryCategoryLevel3);

}
