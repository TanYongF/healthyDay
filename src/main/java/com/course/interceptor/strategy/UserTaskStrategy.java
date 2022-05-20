package com.course.interceptor.strategy;

import com.course.pojo.Event;
import com.course.pojo.User;
import com.course.service.CreditTransactionService;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

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

    protected Event event;
    

    public UserTaskStrategy(Event event) {
        this.event = event;
    }

    public UserTaskStrategy() {
        
    }
    
    /**
     * @author tyf
     * @description 策略前置操作：通常是取得事件类型等
     * @date 17:26 2022/5/20
     **/
    public void preOperation(User user, String token, HttpServletRequest request){
        return;
    }

    /**
     * @author tyf
     * @description 积分策略后置操作
     * @date 17:26 2022/5/20
     **/
    public void completeOperation(User user,String token, HttpServletRequest request){
        return;
    }

    @Override
    public void finishedUserIntegralTask(User user, String token) {
        preOperation(user, token, null);
        creditTransactionService.insert(user, event);
        completeOperation(user, token, null);
    }



    @Override
    public void finishedUserIntegralTask(User user, String token, HttpServletRequest request) {
        preOperation(user, token, request);
        creditTransactionService.insert(user, event);
        completeOperation(user, token, request);
    }
}
