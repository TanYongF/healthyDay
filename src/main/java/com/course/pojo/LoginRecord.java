package com.course.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Describe: 登陆日志
 * @Author: tyf
 * @CreateTime: 2022/5/11
 **/
@NoArgsConstructor
@Data
public class LoginRecord {
    private static final long serialVersionUID = 123432456789L;
    private Long id;
    private Long userId;
    private Date loginTime;
    private String ip;
    private String device;

}