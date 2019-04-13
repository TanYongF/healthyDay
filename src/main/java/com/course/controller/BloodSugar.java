package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//记录血糖
public class BloodSugar {

    public void bloodSugar(){
        System.out.println("======被拦截的bloodSugar方法执行======");
    }

}
