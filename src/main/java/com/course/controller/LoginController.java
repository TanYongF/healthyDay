package com.course.controller;

import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.UserService;
import com.course.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @Describe: 登陆模块Controller
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/

@Controller
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    /**
     * 注册账号逻辑
     * @param userVo ：用户
     * @return
     */
    @ResponseBody
    @PostMapping("/do_register/")
    public Result<CodeMsg> doRegister(@Validated UserVo userVo){
        userService.register(userVo.getMobile(), userVo.getPassword());
        return Result.success(CodeMsg.REGISTER_SUCCESS);
    }

    @GetMapping("/do_register")
    public String register(){
        return "register";
    }


    @GetMapping("/do_login")
    public String login(HttpServletResponse response, User user) {
        if (user != null) {
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "login";
    }

    /**
     * 登陆逻辑
     *
     * @param userVo:用户登陆表单
     * @param response:      Response
     * @return Result数据
     */
    @PostMapping("/do_login")
    @ResponseBody
    public Result<CodeMsg> doLogin(@Validated UserVo userVo, HttpServletResponse response, HttpServletRequest request) {
        logger.info("【用户登陆提醒】" + userVo.toString() + "尝试登陆....");
        userService.login(userVo, response);
        return Result.success(CodeMsg.SUCCESS);
    }
}
