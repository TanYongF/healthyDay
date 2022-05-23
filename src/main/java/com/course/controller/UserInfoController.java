package com.course.controller;

import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.UserInfoService;
import com.course.validator.NeedAuth;
import com.course.vo.UserDTO;
import com.course.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @NeedAuth
    @PostMapping("/update")
    public Result<CodeMsg> updateUserInfo(User user, @RequestBody UserInfoVO userInfoVO) {
        userInfoVO.setId(user.getId() + "");
        userInfoService.updateInfo(userInfoVO);
        return Result.success(CodeMsg.SUCCESS);
    }

    @ResponseBody
    @NeedAuth
    @PostMapping("/updateComplication")
    public Result<CodeMsg> updateComplication(User user, @RequestBody UserInfoVO userInfoVO) {
        userInfoService.updateComplication(userInfoVO);
        return Result.success(CodeMsg.SUCCESS);
    }


}
