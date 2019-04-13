package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//填写并发症记录
public class BfzNote {

    public void bfzNote(){
        System.out.println("======被拦截的bfzNote方法执行======");
    }

}
