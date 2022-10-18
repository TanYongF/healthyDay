package com.course.coursedesign2022.controller;
import com.course.coursedesign2022.pojo.PointObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.course.coursedesign2022.service.TestDesign;

@RestController
public class TestDesignController {
    @Autowired
    private TestDesign testDesign;
    @PutMapping("/testDesign/{id}")
    public String testDesign(@PathVariable("id") Integer id){
        testDesign.testDesign(id);
        return("ok");
    }
}
