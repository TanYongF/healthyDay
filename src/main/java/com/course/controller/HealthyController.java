package com.course.controller;

import com.course.pojo.User;
import com.course.validator.NeedAuth;
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
    @NeedAuth
    public String getIndex(User user){
        return "/admin/index";
    }

    @GetMapping("/health")
    @NeedAuth
    public String getHealthy(){
        return "/admin/health";
    }

    @NeedAuth
    @GetMapping("/activities")
    public String getAllAct(){
        return "/admin/activities";
    }


}
