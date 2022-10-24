package com.course.interceptor.strategy;

import com.course.pojo.Event;
import org.springframework.stereotype.Component;


/**
 * @describe: 用户更新个人信息策略
 * @author: tyf
 * @createTime: 2022/5/18 09:48
 **/
@Component
@UserTaskStrategyType(uri = {"/u/update"})
public class UpdateInfoStrategy extends UserTaskStrategy {

    public UpdateInfoStrategy() {
        super(Event.UPDATE_USER_DETAIL);
    }

}
