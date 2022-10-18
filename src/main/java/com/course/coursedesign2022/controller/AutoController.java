package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.PointObject;
import com.course.coursedesign2022.pojo.userInfo;
import com.course.coursedesign2022.pojo.userInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {
    @Autowired
    private userInfoMapper userInfoMapper;

    @GetMapping(value ="/AutoUser/query/{id}")
    public userInfo getAutoUSer(@PathVariable("id") Integer id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @PostMapping(value="/AutoUSer")
    public userInfo addAutoUser(@RequestParam("id") int id,
                                @RequestParam("exchange")int exchange,
                                @RequestParam("grow") int grow,
                                @RequestParam("total") int total){
        userInfo userInfo =new userInfo();
        userInfo.setExchangescore(exchange);
        userInfo.setGrowscore(grow);
        userInfo.setId(id);
        userInfo.setScoretotal(total);
        userInfoMapper.insertSelective(userInfo);
        return userInfoMapper.selectByPrimaryKey(id);
    }
    @DeleteMapping(value="/AutoUser/{id}")
    public userInfo deleteUserByID(@PathVariable("id") Integer id){
        userInfoMapper.deleteByPrimaryKey(id);
        userInfo userInfo=userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @PutMapping(value="/user/{id}")
    public userInfo updateUser(@PathVariable("id") Integer id,
                                  @RequestParam("grow") Integer grow,
                                  @RequestParam("exchange") Integer exchange,
                                  @RequestParam("total") Integer total){
        userInfo userInfo=userInfoMapper.selectByPrimaryKey(id);
        userInfo.setId(id);
        userInfo.setExchangescore(exchange);
        userInfo.setGrowscore(grow);
        userInfo.setScoretotal(total);
        userInfoMapper.updateByPrimaryKey(userInfo);
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
