package com.course.interceptor.strategy;

import com.course.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author tyf
 * @description user login task
 * @date 10:26 2022/5/12
 **/

@UserTaskStrategyType(uri = {"/login/do_login"})
@Component
public class LoginUserTaskStrategy implements IUserTaskStrategy{

    @Override
    public void finishedUserIntegralTask(User user) {

    }
}
