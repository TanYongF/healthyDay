package com.course.util;

import cn.hutool.core.lang.UUID;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
