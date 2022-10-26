package com.course.service;

import com.course.dao.ActivityDao;
import com.course.dao.CreditTransactionDao;
import com.course.pojo.Activity;
import com.course.pojo.CreditTransaction;
import com.course.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 活动业务层
 * @author: tyf
 * @createTime: 2022/5/20 15:49
 **/
@Service
public class ActivityService {

    @Autowired
    CreditTransactionDao creditTransactionDao;

    @Autowired
    ActivityDao activityDao;

    public boolean canJoin(User user, Activity activity) {
        List<CreditTransaction> cts = creditTransactionDao.getByIdAndEventId(user.getId(), activity.getEventId());
        if(cts == null || cts.isEmpty()){
            return true;
        }
        return false;
    }

    public Activity getById(Long activityId) {
        Activity activity = activityDao.getById(activityId);
        return activity;
    }

    public List<Activity> getAll() {
        List<Activity> activities = activityDao.getAll();
        return activities;
    }
}
