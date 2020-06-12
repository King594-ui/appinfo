package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.DataDictionary;
import com.bdqn.servlet.appdevUser;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 用户查询
 * @date 2020-06-12 10:13
 */
@Controller
public class devloperController {
    @Resource
    private appdevUser appdevUser;
    @Resource
    private appDataDictionaryColler appDataDictionaryColler;
    @RequestMapping("/list1")
    public String lists1(Model model, HttpServletRequest request){
        String querySoftwareName=request.getParameter("querySoftwareName");
        System.out.println(querySoftwareName);

        String queryStatus1=request.getParameter("queryStatus");
        Long queryStatus=null;
        if(!StringUtils.isNullOrEmpty(queryStatus1)){
            queryStatus=Long.parseLong(queryStatus1);
        }

        String queryFlatformId1=request.getParameter("queryFlatformId");
        Long queryFlatformId=null;
        if(!StringUtils.isNullOrEmpty(queryFlatformId1)){
            queryFlatformId=Long.parseLong(queryFlatformId1);
        }

        String queryCategoryLevel12=request.getParameter("queryCategoryLevel1");
        Long queryCategoryLevel1=null;
        if(!StringUtils.isNullOrEmpty(queryCategoryLevel12)){
            queryCategoryLevel1=Long.parseLong(queryCategoryLevel12);
        }

        List<DataDictionary> statusList=appDataDictionaryColler.getappcategorylist();
        List<DataDictionary> flatFormList=appDataDictionaryColler.getappcategorylist1();
        List<AppCategory> categoryLevel1List=appDataDictionaryColler.getappcategorylist2("ALL",null);//1

        List<AppCategory> categoryLevel2List=null;
        String categorylevel2=request.getParameter("queryCategoryLevel2");
        Long queryCategoryLevel2=null;
        if(!StringUtils.isNullOrEmpty(categorylevel2)){
            queryCategoryLevel2=Long.parseLong(categorylevel2);
            categoryLevel2List=appDataDictionaryColler.getappcategorylist2("",queryCategoryLevel2);
        }


        List<AppCategory> categoryLevel3List=null;
        String categorylevel3=request.getParameter("queryCategoryLevel3");
        Long queryCategoryLevel3=null;
        if(!StringUtils.isNullOrEmpty(categorylevel3)){
            queryCategoryLevel3=Long.parseLong(categorylevel3);
            categoryLevel3List=appDataDictionaryColler.getappcategorylist2("",queryCategoryLevel3);
        }

        List<AppInfo> appInfoList= appdevUser.getAppinfoList(querySoftwareName,queryStatus,queryFlatformId,
                queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);

        model.addAttribute("appInfoList",appInfoList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        //回显
        model.addAttribute("querySoftwareName",querySoftwareName);
        model.addAttribute("queryStatus",queryStatus);
        model.addAttribute("queryFlatformId",queryFlatformId);
        model.addAttribute("queryCategoryLevel1",queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2",queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3",queryCategoryLevel3);
        return "developer/appinfolist";
    }
    @RequestMapping("categorylevellist")
    @ResponseBody
    public Object score(HttpServletRequest request,Model model){
        String id=request.getParameter("pid");
        List<AppCategory> lis=appDataDictionaryColler.categorylevellist(Long.parseLong(id));
        return JSONArray.toJSONString(lis);
    }
}
