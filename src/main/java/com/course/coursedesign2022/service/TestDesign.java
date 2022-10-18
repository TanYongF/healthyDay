package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.UserMapper;
import com.course.coursedesign2022.pojo.PointObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestDesign {
    @Autowired
    UserMapper userMapper;
    public  void testDesign(int id){
        PointObject pointObject=userMapper.getPointObjectByID(id);
        int exchange=pointObject.getExchangeScore();
        int grow=pointObject.getGrowScore();
        int total=pointObject.getScoreTotal();
        pointObject.setScoreTotal(total+2);
        pointObject.setGrowScore(grow+1);
        pointObject.setExchangeScore(exchange+1);
        userMapper.updatePointObject(pointObject);
        System.out.println("testDesign execute");
    }
}
