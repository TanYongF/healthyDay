package com.course.interceptor.strategy;

import com.course.pojo.Event;
import com.course.pojo.User;
import com.course.service.CreditTransactionService;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @describe: 胰岛素填报加分逻辑
 * @author: tyf
 * @createTime: 2022/5/18 09:47
 **/
@Component
@UserTaskStrategyType(uri = {"/inr/update"})
public class UpdateINRStrategy implements IUserTaskStrategy {

    @Autowired
    UserService userService;

    @Autowired
    CreditTransactionService creditTransactionService;

    @Override
    public void finishedUserIntegralTask(User user, String token) {
        //insert the credit record in database
        creditTransactionService.insert(user, Event.UPDATE_INR_RECORD);
    }
}
