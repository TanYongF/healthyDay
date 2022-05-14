package com.course.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/15
 **/
@Configuration
@Data
@ToString
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String host;
    private int port;
    /**
     * 秒
     */
    private int timeout;
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    /**
     * 单位：秒
     */
    private int poolMaxWait;
    private int database;

}
