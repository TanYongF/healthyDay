package com.course.controller;

import com.course.pojo.CreditTransaction;
import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.UserInfoService;
import com.course.validator.NeedAuth;
import com.course.vo.CreditTransactionVO;
import com.course.vo.UserDTO;
import com.course.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
        userInfoVO.setId(user.getId() + "");
        userInfoService.updateComplication(userInfoVO);
        return Result.success(CodeMsg.SUCCESS);
    }


    /**
     * 获取用户可兑换积分记录
     * @param user 用户鉴权类
     * @return Map： key=0 : 成长积分， key = 1 ： 成长积分
     */
    @ResponseBody
    @NeedAuth
    @GetMapping("/ctr")
    public Result<HashMap<Integer, List<CreditTransactionVO>>> getCreditRecord(User user){
        HashMap<Integer, List<CreditTransactionVO>> record = new HashMap<>();
        List<CreditTransactionVO> gcRecords = userInfoService.getCreditRecordByType(user.getId(), (byte) 0);
        List<CreditTransactionVO> ecRecords = userInfoService.getCreditRecordByType(user.getId(), (byte) 1);
        record.put(0, gcRecords);
        record.put(1, ecRecords);
        return Result.success(record);
    }
}
