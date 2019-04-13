package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//监测胰岛功能
public class YdgnNote {

    public void ydgnNote(){
        System.out.println("======被拦截的ydgnNote方法执行======");
    }

}
