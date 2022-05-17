package com.course.interceptor.strategy;

import com.course.pojo.User;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @describe: 用户更新血糖记录策略
 * @author: tyf
 * @createTime: 2022/5/12 10:28
 **/
@Component
@UserTaskStrategyType(uri = {"/login/do_login"})
public class UpdateBSUserTaskStrategy implements IUserTaskStrategy {

    @Autowired
    UserService userService;


    @Override
    public void finishedUserIntegralTask(User user, String token) {


    }
}
