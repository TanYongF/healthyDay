package com.course.controller;

import com.course.pojo.User;
import com.course.result.Result;
import com.course.service.UserInfoService;
import com.course.validator.NeedAuth;
import com.course.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describe: 用户信息接口
 * @author: tyf
 * @createTime: 2022/5/16 14:30
 **/
@Controller
@RequestMapping("/u")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ResponseBody
    @NeedAuth
    @GetMapping("/info")
    public Result<UserDTO> getUserInfo(User user) {
        UserDTO userDetail = userInfoService.getUserDetails(user.getId());
        return Result.success(userDetail);
    }


}
