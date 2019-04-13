package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//生成评估报告
public class EvaluateReport {

    public void evaluateReport(){
        System.out.println("======被拦截的evaluateReport方法执行======");
    }

}
