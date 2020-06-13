package com.bdqn.controller;

import com.bdqn.mapper.BackendUser;
import com.bdqn.servlet.appdevUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 啊桥哦
 * @Description: 后台
 * @date 2020-06-12 10:11
 */
@Controller
public class BackendController {

    @Resource
    private appdevUser appdevUser;
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
            request.getSession().setAttribute("userSession",backendUser);
            return "backend/main";
        }else{
            model.addAttribute("账号密码错误");
            return "backendlogin";
        }
    }
}
