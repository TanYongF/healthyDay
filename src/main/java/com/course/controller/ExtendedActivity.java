package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//参加扩展活动
public class ExtendedActivity {

    public void extendedActivity(){
        System.out.println("======被拦截的extendedActivity方法执行======");
    }

}
