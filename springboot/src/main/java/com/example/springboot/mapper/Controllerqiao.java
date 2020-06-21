package com.example.springboot.mapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author 啊桥哦
 * @Description: 实体类
 * @date 2020-06-17 11:26
 */
@Configuration
public class Controllerqiao {

    @Value("${etc.name}")
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
