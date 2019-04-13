package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//填写个人资料
public class FillInformation {

    public void fillInformation(){
        System.out.println("======被拦截的fillInformation方法执行======");
    }

}
