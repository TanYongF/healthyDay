package com.course.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Describe: 鉴权模块
 * @Author: tyf
 * @CreateTime: 2022/4/21
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取注解
        boolean hasAuth = false;

        return hasAuth;
    }

}
