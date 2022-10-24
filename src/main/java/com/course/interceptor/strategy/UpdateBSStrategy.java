package com.course.interceptor.strategy;

import com.course.pojo.Event;
import org.springframework.stereotype.Component;


/**
 * @describe: 用户更新血糖记录策略
 * @author: tyf
 * @createTime: 2022/5/12 10:28
 **/
@Component
@UserTaskStrategyType(uri = {"/bsr/update"})
public class UpdateBSStrategy extends UserTaskStrategy {

    public UpdateBSStrategy() {
        super(Event.UPDATE_BSR_RECORD);
    }

}
