package com.course.service;

import com.course.dao.BSRDao;
import com.course.pojo.BloodSugarRecord;
import com.course.vo.BSRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 类描述
 * @author: tyf
 * @createTime: 2022/5/14 12:43
 **/
@Service
public class BSRService {

    @Autowired
    BSRDao bsrDao;

    public List<BloodSugarRecord> getMonthRecord(Long id) {
        List<BloodSugarRecord> records = bsrDao.getById(id, 3);
        return records;
    }

    public void updateBSValue(BSRVO bsrVo) {
        BloodSugarRecord bsr = new BloodSugarRecord();
        bsr.setValue(bsrVo.getValue());
        bsr.setRecordTime(bsrVo.getRecordTime());
        bsr.setUserId(bsrVo.getUserId());
        bsrDao.insert(bsr);
    }
}
