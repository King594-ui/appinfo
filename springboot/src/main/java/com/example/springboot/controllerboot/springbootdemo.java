package com.example.springboot.controllerboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**++
 * @author 啊桥哦
 * @Description: coltroller
 * @date 2020-06-17 10:0922
 */
@RestController
public class springbootdemo {

    @GetMapping(value = "/index")
    public String index(){
        return "欢迎来到我的世界sss啊桥";
    }
}
