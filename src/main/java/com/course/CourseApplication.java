package com.course;

import com.course.controller.BfzNote;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Describe: 启动类
 * @Author: tyf
 * @CreateTime: 2022/4/18
 **/
public class CourseApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

        //test com.course.controller.BfzNote method
        BfzNote bfzNote = context.getBean(BfzNote.class);
        bfzNote.bfzNote();
    }
}
