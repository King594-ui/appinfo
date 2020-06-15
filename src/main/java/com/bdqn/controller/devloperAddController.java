package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.dao.appDataDictionaryColler;
import com.bdqn.mapper.*;
import com.bdqn.servlet.Dictionary.appdevDictionary;
import com.mysql.cj.util.StringUtils;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * @author 啊桥哦
 * @Description: 新增方法
 * @date 2020-06-13 10:24
 */
@Controller
public class devloperAddController {
    private Logger logger= (Logger) LogManager.getLogger(devloperAddController.class);
    @Resource
    private com.bdqn.servlet.appdevUser appdevUser;
    @Resource
    private com.bdqn.dao.appDataDictionaryColler appDataDictionaryColler;

    /**
     * 跳转新增方法
     * @return
     */
    @RequestMapping("/devloperaddsss")
    public String devloperaddsss(){
        return "developer/appinfoadd";
    }
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
        System.out.println(tcode+"asddsa");
        List<DataDictionary> lis=appDataDictionaryColler.getappdatadictionlist(tcode);
        return JSONArray.toJSONString(lis);
    }
    /**
     * 加载平台列表何(修改用)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/appinfomodify/datadictionarylist1.json")
    @ResponseBody
    public String datadictionarylist1(HttpServletRequest request,Model model){
        String tcode=request.getParameter("tcode");
        System.out.println(tcode+"asddsa");
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
    /**
     * 动态加载一二级分类（修改用）
     * @return
     */
    @RequestMapping("/appinfomodify/categorylevellist1.json")
    @ResponseBody
    public String categorylevellist1(HttpServletRequest request,Model model){
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
    @RequestMapping(value = "/devloperadd",method= RequestMethod.POST)
    public String devloperadd(HttpServletRequest request, Model model, AppInfo appInfo, @RequestParam(value = "a_logoPicPath", required = false)MultipartFile attach,HttpSession session) {
        String logoPicPath =  null;
        String logoLocPath =  null;
        if(attach!=null){
            String path=request.getSession().getServletContext().getRealPath("images"+ File.separator+"uploadfiles");
            System.out.println("uploadFile path=========>"+path);
            String oldFileName=attach.getOriginalFilename();
            System.out.println("源文件名  oldFileName========>"+oldFileName);
            String prefix= FilenameUtils.getExtension(oldFileName);
            System.out.println("源文件后缀 prefix========>"+prefix);
            int filesize=500000;
            System.out.println("uploadFile size==========>"+attach.getSize());
            if (attach.getSize()>filesize){
                request.setAttribute("uploadFileError","* 上传文件不得超过500KB");
                return "developer/appinfoadd";
            }else if(prefix.equalsIgnoreCase("jpg")
                    || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg")
                    || prefix.equalsIgnoreCase("pneg")){
                String fileName=System.currentTimeMillis()+Math.abs(new Random().nextLong())+"_Personal.jpg";
                System.out.println(fileName);
                System.out.println("new fileName==========>"+attach.getName());
                File targetFile=new File(path,fileName);
                if (!targetFile.exists()){
                    targetFile.mkdirs();
                }
                try {
                    attach.transferTo(targetFile);
                }catch(Exception e){
                    e.printStackTrace();
                    request.setAttribute("uploadFileError","* 上传失败");
                    return "developer/appinfoadd";
                }
                logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                logoLocPath = path+File.separator+fileName;
            }else{
                request.setAttribute("uploadFileError","上传图片格式不正确");
                return "developer/appinfoadd";
            }
        }
        String flatformId=request.getParameter("flatformId");
        System.out.println(flatformId);
        appInfo.setCreatedBy(((DevUser)session.getAttribute("devUserSession")).getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoPicPath(logoPicPath);
        appInfo.setLogoLocPath(logoLocPath);
        appInfo.setDevId(((DevUser)session.getAttribute("devUserSession")).getId());
        appInfo.setStatus(9L);
        int count=appDataDictionaryColler.getappinfoAdd(appInfo);
        if(count>0){
            return "redirect:/list1";
        }else{
            return "developer/appinfoadd";
        }
    }

    /***
     * 判断APKname是否重复
     * @param request
     * @return
     */
    @RequestMapping("/apknamechaxun")
    @ResponseBody
    public Object apknamechaxun(HttpServletRequest request){
        String APKName=request.getParameter("APKName");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(APKName)){
            int count = appDataDictionaryColler.getapkname(APKName);
            if(count>0){
                resultMap.put("APKName", "exist");
            }else{
                resultMap.put("APKName", "noexist");
            }
        }else{
            resultMap.put("APKName", "empty");
        }
        return JSONArray.toJSONString(resultMap);
    }

    /***
     *信息查看
     * @return
     */
    @RequestMapping(value = "/appviewss/{id}",method = RequestMethod.GET)
    public String appchaxun(@PathVariable Long id,Model model){
        List<AppVersion> appVersionList = null;
        AppInfo appInfo= appDataDictionaryColler.appdevloperchaxun(id);
        appVersionList=appDataDictionaryColler.getAppVersionList(id);
        System.out.println(appInfo);
        model.addAttribute("appInfo",appInfo);
       model.addAttribute("appVersionList",appVersionList);
        return "developer/appinfoview";
    }
    /***
     * 删除操作
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("delapp.json")
    @ResponseBody
    public String delapp(HttpServletRequest request,Model model){
            String id=request.getParameter("id");
            Long ids=null;
            if(!StringUtils.isNullOrEmpty(id)){
                ids=Long.parseLong(id);
            }
            HashMap<String, String> resultMap = new HashMap<String, String>();
            if(!StringUtils.isNullOrEmpty(id)){
                int count=appDataDictionaryColler.delapp(ids);
                if(count>0){
                    resultMap.put("delResult","true");
                }else {
                    resultMap.put("delResult","false");
                }
            }else {
                resultMap.put("delResult","notexist");
            }
            return JSONArray.toJSONString(resultMap);
    }

    /**
     * 修改把值放到文本框里面操作
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/appinfomodify/{id}")
    public String appinfomodify(@PathVariable Long id,HttpServletRequest request,Model model){
        AppInfo appInfo=appDataDictionaryColler.appdevloperchaxun(id);
        model.addAttribute("appInfo",appInfo);
        return "developer/appinfomodify";
    }

    /**
     * 点击保存按钮修改操作
     * @param appInfo
     * @param request
     * @param model 吧
     * @param multipartFile
     * @param session
     * @return
     */
    @RequestMapping("/appinfomodifysave")
    public String appinfoupdate(AppInfo appInfo,HttpServletRequest request,Model model,MultipartFile multipartFile,HttpSession session){
        String logoPicPath =  null;
        String logoLocPath =  null;
        if(multipartFile!=null){
            String path=request.getSession().getServletContext().getRealPath("images"+ File.separator+"uploadfiles");
            System.out.println("uploadFile path=========>"+path);
            String oldFileName=multipartFile.getOriginalFilename();
            System.out.println("源文件名  oldFileName========>"+oldFileName);
            String prefix= FilenameUtils.getExtension(oldFileName);
            System.out.println("源文件后缀 prefix========>"+prefix);
            int filesize=500000;
            System.out.println("uploadFile size==========>"+multipartFile.getSize());
            if (multipartFile.getSize()>filesize){
                request.setAttribute("uploadFileError","* 上传文件不得超过500KB");
                return "provideradd";
            }else if(prefix.equalsIgnoreCase("jpg")
                    || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg")
                    || prefix.equalsIgnoreCase("pneg")){
                String fileName=System.currentTimeMillis()+Math.abs(new Random().nextLong())+"_Personal.jpg";
                System.out.println(fileName);
                System.out.println("new fileName==========>"+multipartFile.getName());
                File targetFile=new File(path,fileName);
                if (!targetFile.exists()){
                    targetFile.mkdirs();
                }
                try {
                    multipartFile.transferTo(targetFile);
                }catch(Exception e){
                    e.printStackTrace();
                    request.setAttribute("uploadFileError","* 上传失败");
                    return "provideradd";
                }
                logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                logoLocPath = path+File.separator+fileName;
            }else{
                request.setAttribute("uploadFileError","上传图片格式不正确");
            }
        }
        appInfo.setCreatedBy(((DevUser)session.getAttribute("devUserSession")).getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoPicPath(logoPicPath);
        appInfo.setLogoLocPath(logoLocPath);
        appInfo.setDevId(((DevUser)session.getAttribute("devUserSession")).getId());
        int count=appDataDictionaryColler.updateByPrimaryKeySelective(appInfo);
        if (count>0){
            return "redirect:/list1";
        }else{
            return "developer/appinfomodify";
        }
    }

    /**
     * 查看版本方法
     * @param request
     * @param id
     * @param aid
     * @param model
     * @return
     */
    @RequestMapping("/appversionmodify/{id}/{aid}")
    public String appversionmodify(HttpServletRequest request,@PathVariable Long id,@PathVariable Long aid,Model model){
        AppVersion appVersion=appDataDictionaryColler.getappVersionUpdate(id,aid);
        System.out.println(appVersion);
        model.addAttribute("appVersion",appVersion);
        return "developer/appversionmodify";
    }
}
