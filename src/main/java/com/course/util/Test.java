package com.course.util;

import cn.hutool.json.JSONUtil;
import com.course.pojo.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @describe: 类描述
 * @author: tyf
 * @createTime: 2022/5/17 10:39
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File("E:/event.json"));
        BufferedReader reader = new BufferedReader(fileReader);
        String str = "", temp = "";
        StringBuilder sb = new StringBuilder("");
        sb.append("public static final Event DAILY_LOGIN_RECORD = new ");

        while((temp =reader.readLine()) != null){
            str += temp;

        }
        List<Event> events = JSONUtil.toList(str, Event.class);
        for(Event event : events){

            System.out.println(sb + event.toString() + ";");
        }
    }
}
