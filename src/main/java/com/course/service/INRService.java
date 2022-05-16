package com.course.service;

import com.course.dao.INRDao;
import com.course.pojo.InsulinRecord;
import com.course.vo.INRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 类描述
 * @author: tyf
 * @createTime: 2022/5/15 10:23
 **/
@Service
public class INRService {


    @Autowired
    INRDao inrDao;

    public List<InsulinRecord> getMonthRecord(Long id) {
        return inrDao.getById(id);
    }

    public void updateINValue(INRVO inrVo) {
        InsulinRecord inr = new InsulinRecord();
        inr.setValue(inrVo.getValue());
        inr.setRecordTime(inrVo.getRecordTime());
        inr.setUserId(inrVo.getUserId());
        inrDao.insert(inr);
    }

}
