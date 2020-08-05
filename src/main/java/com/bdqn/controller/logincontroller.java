package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.mapper.DevUser;
import com.bdqn.servlet.appdevUser;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 啊桥哦
 * @Description: 登陆
 * @date 2020-06-10 17:36
 */
@Controller
public class logincontroller {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
/*    @Resource
    private RedisTemplate redisTemplate;*/

    @Resource
    private appdevUser appdevUser;

    @RequestMapping(value = "denglu")
    public String denglu(){
        return "devlogin";
    }

    @RequestMapping(value = "zhuxiao")
    public String zhuxiao(){
        return "index";
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
                Map<String,String> resultmap=new HashMap<String,String>();
                resultmap.put("name",name);
                resultmap.put("pass",pass);
                String qiao= JSONArray.toJSONString(resultmap);
//                stringRedisTemplate.opsForValue().set("luqiao",qiao);
                /*redisTemplate.opsForValue().set("name",name);
                redisTemplate.opsForValue().set("pass",pass);*/
                request.getSession().setAttribute("devUserSession",devUser);
                return "developer/main";
            }else{
                model.addAttribute("error","账号密码错误");
                return "devlogin";
            }
    }
}
