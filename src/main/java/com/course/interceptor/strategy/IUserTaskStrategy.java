package com.course.interceptor.strategy;

import com.course.pojo.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tyf
 * @description define the strategy method
 * @date 10:23 2022/5/12
 **/
public interface IUserTaskStrategy {

    /**
     * 主要声明具体增加积分逻辑
     *
     * @param user  用户对象
     * @param token
     */
    void finishedUserIntegralTask(User user, String token);
    void finishedUserIntegralTask(User user, String token, HttpServletRequest request);
}
