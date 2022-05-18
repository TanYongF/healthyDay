package com.course.interceptor.strategy;

import com.course.pojo.Event;
import com.course.service.CreditTransactionService;
import com.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @describe: 用户更新血糖记录策略
 * @author: tyf
 * @createTime: 2022/5/12 10:28
 **/
@Component
@UserTaskStrategyType(uri = {"/bsr/update"})
public class UpdateBSStrategy extends UserTaskStrategy {

    @Autowired
    UserService userService;

    @Autowired
    CreditTransactionService creditTransactionService;

    public UpdateBSStrategy() {
        super(Event.UPDATE_BSR_RECORD);
    }

}
