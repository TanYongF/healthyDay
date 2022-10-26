package com.course.interceptor.strategy;

import com.course.pojo.Event;
import org.springframework.stereotype.Component;


@Component
@UserTaskStrategyType(uri = {"/u/updateComplication"})
/**
 * @describe: 并发症更新策略
 * @author: tyf
 * @createTime: 2022/5/18 11:50
 **/
public class UpdateComplicationStrategy extends UserTaskStrategy {

    public UpdateComplicationStrategy() {
        super(Event.UPDATE_USER_COMPLICATION);
    }
}
