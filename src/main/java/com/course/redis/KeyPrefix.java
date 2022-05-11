package com.course.redis;

/**
 * @Describe 前缀
 * @Author tyf
 * @CreateTime 2022/5/11
 **/
public interface KeyPrefix {

    /**
     * 获取失效时间
     * @return 过期时间
     */
    int expireSecond();

    /**
     * 获取前缀
     * @return
     */
    String getPrefix();
}
