package com.course.interceptor.strategy;

import com.course.pojo.Activity;
import com.course.pojo.Event;
import com.course.pojo.User;
import com.course.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @describe: 参加活动逻辑
 * @author: tyf
 * @createTime: 2022/5/20 16:41
 **/
@UserTaskStrategyType(uri = {"/act/join"})
@Component
//TODO 注解是否需要加
public class ActivityJoinStrategy extends UserTaskStrategy{

    @Autowired
    ActivityService activityService;


    @Override
    public void preOperation(User user, String token, HttpServletRequest request) {
        //获取活动ID
        String activityId = request.getParameter("activityId");
        Activity activity = activityService.getById(Long.valueOf(activityId));
        Event event = Event.eventMap.get(activity.getEventId());
        this.event = event;
    }
}
