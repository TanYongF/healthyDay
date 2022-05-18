package com.course.interceptor.strategy;

import com.course.pojo.Event;
import com.course.pojo.User;
import com.course.service.CreditTransactionService;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @describe: 用户逻辑抽象类
 * @author: tyf
 * @createTime: 2022/5/18 11:51
 **/
public abstract class UserTaskStrategy implements IUserTaskStrategy {

    @Autowired
    UserService userService;

    @Autowired
    CreditTransactionService creditTransactionService;

    private Event event;

    public UserTaskStrategy(Event event) {
        this.event = event;
    }

    @Override
    public void finishedUserIntegralTask(User user, String token) {
        creditTransactionService.insert(user, event);
    }

}
