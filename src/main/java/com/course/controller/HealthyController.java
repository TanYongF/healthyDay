package com.course.controller;

import com.course.pojo.User;
import com.course.validator.NeedAuth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/5/10
 **/

@Controller
public class HealthyController {

    @GetMapping("")
    public void welcome(HttpServletResponse response){
        try {
            response.sendRedirect("/welcome.htm");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/index")
    @NeedAuth
    public String getIndex(User user){
        return "admin/index";
    }

    @GetMapping("/health")
    @NeedAuth
    public String getHealthy(){
        return "admin/health";
    }

    @NeedAuth
    @GetMapping("/activities")
    public String getAllAct(){
        return "admin/activities";
    }


}
