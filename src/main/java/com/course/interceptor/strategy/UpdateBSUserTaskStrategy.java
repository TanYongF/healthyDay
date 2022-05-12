package com.course.interceptor.strategy;

import com.course.pojo.User;
import org.springframework.stereotype.Component;

@Component
@UserTaskStrategyType(uri = {"/login/do_login"})
/**
 * @describe: 用户更新血糖记录策略
 * @author: tyf
 * @createTime: 2022/5/12 10:28
 **/
public class UpdateBSUserTaskStrategy implements IUserTaskStrategy{
    @Override
    public void finishedUserIntegralTask(User user) {

    }
}
