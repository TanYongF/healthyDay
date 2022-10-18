package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.mapper.UserMapper;
import com.course.coursedesign2022.pojo.PointObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
//    @Autowired
//    private UserMapper userMapper;
//
//    @GetMapping("/getPointObject")
//    public List<PointObject> getPointObject(){
//        List<PointObject> pointObjects=userMapper.getPointObject();
//        for(PointObject pointObject:pointObjects){
//            System.out.println(pointObject);
//        }
//        return pointObjects;
//    }
//
//    @GetMapping("/getPointObjectByID")
//    public PointObject getPointObjectByID(){
//        PointObject pointObject=userMapper.getPointObjectByID(1);
//        System.out.println(pointObject);
//        return pointObject;
//    }
//
//    @GetMapping("/addPointObject")
//    public String addPointObject(){
//        userMapper.addPointObject(new PointObject(1,0,0,0));
//        return "add succeed";
//    }
//
//    @GetMapping("/updatePointObject")
//    public String updatePointObject(){
//        userMapper.updatePointObject(new PointObject(1,1,1,1));
//        return "update succeed";
//    }
//
//    @GetMapping("/deletePointObject")
//    public String deletePointObject(){
//        userMapper.deletePointObject(4);
//        return "update succeed";
//    }
}
