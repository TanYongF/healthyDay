package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.mapper.UserMapper;
import com.course.coursedesign2022.pojo.PointObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestfulController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    public List<PointObject> getUser(){
        return userMapper.getPointObject();
    }

    @GetMapping(value = "/user/query/{id}")
    public PointObject getUserByID(@PathVariable("id") Integer id){
        return userMapper.getPointObjectByID(id);
    }

    @PostMapping(value = "/user")
    public PointObject addUser(@RequestParam("id") int id,
                               @RequestParam("exchange") int exchange,
                               @RequestParam("grow") int grow,
                               @RequestParam("total") int total){
        PointObject pointObject = new PointObject();
        pointObject.setExchangeScore(exchange);
        pointObject.setGrowScore(grow);
        pointObject.setScoreTotal(total);
        pointObject.setId(id);
        userMapper.addPointObject(pointObject);
        return userMapper.getPointObjectByID(id);

    }

    @DeleteMapping(value="/user/{id}")
    public List<PointObject> deleteUserByID(@PathVariable("id") Integer id){
        userMapper.deletePointObject(id);
        List<PointObject> pointObjects=userMapper.getPointObject();
        return pointObjects;
    }

    @PutMapping(value="/user/{id}")
    public PointObject updateUser(@PathVariable("id") Integer id,
                                  @RequestParam("grow") Integer grow,
                                  @RequestParam("exchange") Integer exchange,
                                  @RequestParam("total") Integer total){
        PointObject pointObject=userMapper.getPointObjectByID(id);
        pointObject.setId(id);
        pointObject.setScoreTotal(total);
        pointObject.setGrowScore(grow);
        pointObject.setExchangeScore(exchange);
        userMapper.updatePointObject(pointObject);
        return userMapper.getPointObjectByID(id);
    }
}
