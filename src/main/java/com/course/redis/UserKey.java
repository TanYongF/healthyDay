package com.course.redis;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE_TIME = 24 * 60 * 60;
    public static UserKey token = new UserKey(TOKEN_EXPIRE_TIME, "tk");
    public static UserKey getById = new UserKey(0, "id");

    public UserKey(int time, String prefix) {
        super(time, prefix);
    }

}
