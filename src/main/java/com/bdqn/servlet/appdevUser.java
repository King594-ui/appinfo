package com.bdqn.servlet;

import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.BackendUser;
import com.bdqn.mapper.DevUser;
import org.apache.ibatis.annotations.Param;

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
    List<AppInfo> getAppinfoList(String querySoftwareName,
                                 Long queryStatus,
                                 Long queryFlatformId,
                                 Long queryCategoryLevel1,
                                 Long queryCategoryLevel2,
                                  Long queryCategoryLevel3,
                                int currentPageNo,
                                 int pageSize);
    int getappinfoquanbu(@Param("querySoftwareName") String querySoftwareName,
                                   @Param("queryStatus") Long queryStatus,
                                   @Param("queryFlatformId") Long queryFlatformId,
                                   @Param("queryCategoryLevel1") Long queryCategoryLevel1,
                                   @Param("queryCategoryLevel2") Long queryCategoryLevel2,
                                   @Param("queryCategoryLevel3") Long queryCategoryLevel3);
}
