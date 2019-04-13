package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//登录平台
public class Login {

    public void login(){
        System.out.println("======被拦截的login方法执行======");
    }

}
