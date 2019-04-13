package com.course.controller;

import org.springframework.stereotype.Component;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
@Component
//参加科研招募
public class ResearchRecruitment {

    public void researchRecruitment(){
        System.out.println("======被拦截的researchRecruitment方法执行======");
    }

}
