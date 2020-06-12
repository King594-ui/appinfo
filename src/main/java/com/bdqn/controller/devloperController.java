package com.bdqn.controller;

import com.bdqn.mapper.AppInfo;
import com.bdqn.servlet.appdevUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @RequestMapping("/list1")
    public String lists1(Model model){
        List<AppInfo> appInfoList= appdevUser.getAppinfoList();
        model.addAttribute("appInfoList",appInfoList);
        return "developer/appinfolist";
    }
}
