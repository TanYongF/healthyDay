package com.course.interceptor.strategy;

import com.course.pojo.User;

/**
 * @author tyf
 * @description define the strategy method
 * @date 10:23 2022/5/12
 **/
public interface IUserTaskStrategy {

    /**
     * @param user 用户对象
     */
    void finishedUserIntegralTask(User user);
}
