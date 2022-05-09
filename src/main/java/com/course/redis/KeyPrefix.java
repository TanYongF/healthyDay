package com.course.redis;

public interface KeyPrefix {

    int expireSecond();

    String getPrefix();
}
