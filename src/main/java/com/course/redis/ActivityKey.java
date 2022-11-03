package com.course.redis;

/**
 * @Describe: Redis中User对象的键名称
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
public class ActivityKey extends BasePrefix {

    //缓存活动数据
    public static ActivityKey activity = new ActivityKey(0, "activity");
    public ActivityKey(int time, String prefix) {
        super(time, prefix);
    }

}
