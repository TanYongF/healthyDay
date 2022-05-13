package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/5/10
 **/

@Controller
public class HealthyController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
