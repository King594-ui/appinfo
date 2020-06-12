package com.bdqn.sysinterceptor;
import com.bdqn.mapper.DevUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ssmsmbms
 * @description: session拦截器
 * @author:桥
 * @create: 2020-06-01 10:57
 **/

public class SysInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger= LogManager.getLogger(SysInterceptor.class);
    /**
     * 配置前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DevUser user=(DevUser) request.getSession().getAttribute("devUserSession");
        logger.info("进入拦截器");
        if(user!=null){
            logger.info("通过，放行");
            return  true;
        }else{
            response.sendRedirect("/WEB-INF/jsp/devlogin.jsp");
            return false;
        }

    }
}
