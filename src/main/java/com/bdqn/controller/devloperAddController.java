package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.mapper.AppCategory;
import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.DataDictionary;
import com.bdqn.mapper.appinfo1;
import com.bdqn.servlet.Dictionary.appdevDictionary;
import com.bdqn.servlet.appdevUser;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 新增方法
 * @date 2020-06-13 10:24
 */
@Controller
public class devloperAddController {
    @Resource
    private com.bdqn.servlet.appdevUser appdevUser;
    @Resource
    private com.bdqn.dao.appDataDictionaryColler appDataDictionaryColler;


    /**
     * 加载平台列表何
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/datadictionarylist.json")
    @ResponseBody
    public String datadictionarylist(HttpServletRequest request,Model model){
        String tcode=request.getParameter("tcode");
        System.out.println(tcode);
        List<DataDictionary> lis=appDataDictionaryColler.getappdatadictionlist(tcode);
        return JSONArray.toJSONString(lis);
    }

    /**
     * 动态加载一二级分类
     * @return
     */
    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    public String categorylevellist(HttpServletRequest request,Model model){
        String pid=request.getParameter("pid");
        Long pids=0L;
        if(!StringUtils.isNullOrEmpty(pid)){
            pids=Long.parseLong(pid);
        }
        List<AppCategory> list=appDataDictionaryColler.getappcategorylist4(pids);
        return JSONArray.toJSONString(list);
    }
    /***
     * 新增操作
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/devloperadd")
    public String devloperadd(HttpServletRequest request, Model model, appinfo1 appinfo1){
        AppInfo appInfo=new AppInfo();
        BeanUtils.copyProperties(appinfo1,appInfo);
        List<DataDictionary> flatformId=appDataDictionaryColler.getappcategorylist();
        model.addAttribute("flatformId",flatformId);
        return "developer/appinfoadd";
    }
}
