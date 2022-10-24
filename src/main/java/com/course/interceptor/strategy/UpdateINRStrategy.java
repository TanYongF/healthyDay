package com.course.interceptor.strategy;

import com.course.pojo.Event;
import org.springframework.stereotype.Component;

/**
 * @describe: 胰岛素填报加分逻辑
 * @author: tyf
 * @createTime: 2022/5/18 09:47
 **/
@Component
@UserTaskStrategyType(uri = {"/inr/update"})
public class UpdateINRStrategy extends UserTaskStrategy {

    public UpdateINRStrategy() {
        super(Event.UPDATE_INR_RECORD);
    }

}
