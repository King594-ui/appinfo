package com.bdqn.controller;

import com.bdqn.mapper.AppInfo;
import com.bdqn.mapper.BackendUser;
import com.bdqn.mapper.DevUser;
import com.bdqn.servlet.appdevUser;
import com.bdqn.servlet.appdevUserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 啊桥哦
 * @Description: 登陆
 * @date 2020-06-10 17:36
 */
@Controller
public class logincontroller {

    @Resource
    private appdevUser appdevUser;

    @RequestMapping(value = "denglu")
    public String denglu(){
        return "devlogin";
    }


    @RequestMapping(value = "zhuxiao")
    public String zhuxiao(){
        return "devlogin";
    }

    /**
     * 前台登陆
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "denglulu")
    public String denglulu(HttpServletRequest request, Model model){
        String name=request.getParameter("devCode");
        String pass=request.getParameter("devPassword");
        DevUser devUser= appdevUser.login(name,pass);
        if(devUser!=null){
            request.getSession().setAttribute("devUserSession",devUser);
            return "developer/main";
        }else{
            model.addAttribute("error","账号密码错误");
            return "devlogin";
        }
    }



}
