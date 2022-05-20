package com.course.service;

import com.course.dao.CreditTransactionDao;
import com.course.pojo.CreditTransaction;
import com.course.pojo.Event;
import com.course.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @describe: 积分记录接口
 * @author: tyf
 * @createTime: 2022/5/17 09:49
 **/
@Service
public class CreditTransactionService {

    @Autowired
    CreditTransactionDao creditTransactionDao;


    /**
     * 插入积分记录
     * @param user 用户
     * @param event 积分事件
     */
    public void insert(User user, Event event) {
        CreditTransaction creditRecord = new CreditTransaction();
        creditRecord.setUserId(user.getId());
        LocalDateTime curTime = LocalDateTime.now();
        creditRecord.setCreateTime(curTime);
        creditRecord.setEventId(event.getId());
        creditRecord.setExpiredTime(curTime.plusDays(event.getEffectiveDay()));
        //获取是否可插入
        boolean isValid = creditTransactionDao.isValid(creditRecord);
        if(isValid){
            creditTransactionDao.insert(creditRecord);
        }
    }

    public List<CreditTransaction> getByUserAndEventId(User user, Long eventId){
        List<CreditTransaction> cts = creditTransactionDao.getByIdAndEventId(user.getId(), eventId);
        return cts;
    }
}
