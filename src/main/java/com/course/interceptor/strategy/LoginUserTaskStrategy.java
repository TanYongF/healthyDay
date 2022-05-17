package com.course.interceptor.strategy;

import com.course.pojo.CreditTransaction;
import com.course.pojo.Event;
import com.course.pojo.User;
import com.course.redis.RedisService;
import com.course.redis.UserKey;
import com.course.service.CreditTransactionService;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author tyf
 * @description user login task
 * @date 10:26 2022/5/12
 **/

@UserTaskStrategyType(uri = {"/index"})
@Component
public class LoginUserTaskStrategy implements IUserTaskStrategy{

    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @Autowired
    CreditTransactionService creditTransactionService;

    @Override
    public void finishedUserIntegralTask(User user, String token) {
        LocalDate lastLoginDate = user.getLastLoginDate();

        //如果日期为空，或者token中的日期不是今天，那么证明是今天是第一次登陆
        if(lastLoginDate == null || !lastLoginDate.isEqual(LocalDate.now())){
            //update the user last-login-date in database
            user.setLastLoginDate(LocalDate.now());
            userService.updateLastLoginDate(user);

            //insert the credit record in database
            creditTransactionService.insert(user, Event.DAILY_LOGIN_RECORD);

            //remove the date in redis
            redisService.remove(UserKey.getById, user.getId() + "");
            //update the token in redis
            redisService.set(UserKey.token, token, user);
        }
    }
}
