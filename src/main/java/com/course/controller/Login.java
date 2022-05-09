package com.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//登录平台
public class Login {

    @GetMapping("/hello")
    public String getLogin(){
        return "hello";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
