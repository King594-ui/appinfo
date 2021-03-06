package com.bdqn.servlet;

import com.bdqn.dao.appdevuserdao;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.BackendUser;
import com.bdqn.mapper.DevUser;
import com.bdqn.servlet.appdevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 用户
 * @date 2020-06-10 19:08
 */
@Service
public class appdevUserImpl implements appdevUser {
    @Resource
    private appdevuserdao appdevuserdao;
    @Override
    public DevUser login(String devCode, String devPassword) {
        return appdevuserdao.login(devCode,devPassword);
    }

    @Override
    public BackendUser login1(String user_code, String user_password) {
        return appdevuserdao.login1(user_code,user_password);
    }

    @Override
    public List<AppInfo> getAppinfoList(String querySoftwareName,
                                        Long queryStatus,
                                        Long queryFlatformId,
                                        Long queryCategoryLevel1,
                                        Long queryCategoryLevel2,
                                        Long queryCategoryLevel3,int currentPageNo,int pageSize) {
        return appdevuserdao.getAppinfoList(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,currentPageNo,pageSize);
    }

    @Override
    public int getappinfoquanbu(String querySoftwareName, Long queryStatus, Long queryFlatformId, Long queryCategoryLevel1, Long queryCategoryLevel2, Long queryCategoryLevel3) {
        return appdevuserdao.getappinfoquanbu(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
    }

}
