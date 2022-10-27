package com.course.controller;

import com.course.exception.GlobalException;
import com.course.pojo.Activity;
import com.course.pojo.User;
import com.course.result.CodeMsg;
import com.course.result.Result;
import com.course.service.ActivityService;
import com.course.service.CreditTransactionService;
import com.course.validator.NeedAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @describe: 拓展活动接口
 * @author: tyf
 * @createTime: 2022/5/20 15:14
 **/
@Controller
@RequestMapping("/act")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    CreditTransactionService creditTransactionService;

    /**
     * 获取特定活动
     * @param user
     * @param activityId
     * @return
     */
    @GetMapping("/{activityId}")
    @ResponseBody
    @NeedAuth
    public Result<Activity> getActivity(User user, @PathVariable("activityId") Long activityId){
        Activity activity = activityService.getById(activityId);
        return Result.success(activity);
    }

    /**
     * 获取全部活动
     * @param user
     * @return
     */
    @GetMapping("")
    @ResponseBody
    @NeedAuth
    public Result<List<Activity>> getAllActivities(User user){
        List<Activity> activityList = activityService.getAll();
        return Result.success(activityList);
    }

    /**
     * 用户参加活动接口
     * @param user
     * @param activityId
     * @return
     */
    @PostMapping("/join")
    @ResponseBody
    @NeedAuth
    public Result<CodeMsg> doActivity(User user, @Param("activityId") Long activityId){
        Activity activity = activityService.getById(activityId);
        boolean canJoin = activityService.canJoin(user, activity);
        if(!canJoin){
            throw new GlobalException(CodeMsg.ACTIVITY_HAVE_JOINED);
        }
        return Result.success(CodeMsg.SUCCESS);
    }
}
