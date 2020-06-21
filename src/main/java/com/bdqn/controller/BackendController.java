package com.bdqn.controller;

import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.mapper.*;
import com.bdqn.servlet.appdevUser;
import com.bdqn.tools.PageSupport;
import com.mysql.cj.util.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 后台
 * @date 2020-06-12 10:11
 */
@Controller
public class BackendController {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private appdevUser appdevUser;
    @Resource
    private appDataDictionaryColler appDataDictionaryColler;

    @RequestMapping("/list")
    public String lists(){
        return "backend/applist";
    }


    @RequestMapping(value = "denglu1")
    public String denglu1(){
        return "backendlogin";
    }

    /**
     * 后台登陆
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "kaifadenglu")
    public String kaifadenglu(HttpServletRequest request, Model model){
        String name=request.getParameter("userCode");
        String password=request.getParameter("userPassword");
        BackendUser backendUser= appdevUser.login1(name,password);
        if (backendUser!=null){
            redisTemplate.opsForValue().set("name1",name);
            redisTemplate.opsForValue().set("pass1",password);
            request.getSession().setAttribute("userSession",backendUser);
            return "backend/main";
        }else{
            model.addAttribute("账号密码错误");
            return "backendlogin";
        }
    }

    /**
     * 查询
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/qiao")
    public String chaxun(HttpServletRequest request,Model model){
        String querySoftwareName=request.getParameter("querySoftwareName");
        String pageIndex=request.getParameter("pageIndex");
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

        List<DataDictionary> statusList= appDataDictionaryColler.getappcategorylist();
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
        int pageSize =5;//设置页面容量
        int currentPageNo = 1; //当前页码
        if (pageIndex!=null && !pageIndex.equals("")){
            currentPageNo=Integer.parseInt(pageIndex);
        }
        int totalCount	= appdevUser.getappinfoquanbu(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        List<AppInfo> appInfoList= appdevUser.getAppinfoList(querySoftwareName,queryStatus,queryFlatformId,
                queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,((currentPageNo-1)*pageSize),pageSize);

        model.addAttribute("appInfoList",appInfoList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        model.addAttribute("pages",pages);
        //回显
        model.addAttribute("querySoftwareName",querySoftwareName);
        model.addAttribute("queryStatus",queryStatus);
        model.addAttribute("queryFlatformId",queryFlatformId);
        model.addAttribute("queryCategoryLevel1",queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2",queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3",queryCategoryLevel3);
        return "backend/applist";
    }

    /**
     * 审核通过和不通过代码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("check")
    public String check(HttpServletRequest request,Model model){
        String aids=request.getParameter("aid");
        System.out.println(aids);
        String vids=request.getParameter("vid");
        System.out.println(vids);

        Long aid=null;
        if(!StringUtils.isNullOrEmpty(aids)){
            aid=Long.parseLong(aids);
        }
        Long vid=null;
        if(!StringUtils.isNullOrEmpty(vids)){
            vid=Long.parseLong(vids);
        }
        AppInfo appInfo=  appDataDictionaryColler.appdevloperchaxun1(aid);
        List<AppVersion>  appVersion=appDataDictionaryColler.getappVersionUpdate1(aid,vid);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersion",appVersion.get(0));
        return "backend/appcheck";
    }
}
