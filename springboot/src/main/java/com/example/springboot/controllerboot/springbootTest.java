package com.example.springboot.controllerboot;

import com.example.springboot.mapper.Controllerqiao;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 啊桥哦
 * @Description: 测试类
 * @date 2020-06-17 11:25
 */
@RestController
public class springbootTest {
    private  static Logger logger=LoggerFactory.getLogger(springbootTest.class);

    @Resource
    private Controllerqiao controllerqiao;
    @GetMapping(value = "/test")
    public String test(){
        logger.info(controllerqiao.getName());
        return "易烊千玺,艳芬";
    }
}
