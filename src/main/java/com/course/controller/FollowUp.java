package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//完成门诊随访
public class FollowUp {

    public void followUp(){
        System.out.println("======被拦截的followUp方法执行======");
    }

}
