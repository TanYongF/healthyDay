package com.course.redis;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/
public class UserPrefix extends BasePrefix {

    public static UserPrefix getById = new UserPrefix("id");
    public static UserPrefix getByName = new UserPrefix("name");

    public UserPrefix(String prefix) {
        super(prefix);
    }


}
