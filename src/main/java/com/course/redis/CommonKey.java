package com.course.redis;

/**
 * @Describe: Redis中User对象的键名称
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
public class CommonKey extends BasePrefix {

    //缓存静态界面
    public static CommonKey page = new CommonKey(0, "page");
    public CommonKey(int time, String prefix) {
        super(time, prefix);
    }

}
