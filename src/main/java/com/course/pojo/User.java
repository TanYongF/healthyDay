package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/5/6
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String nickname;
    private byte gender;
    private String password;
    private String salt;
    private String head;
    private LocalDate registerDate;
    private LocalDate lastLoginDate;
    private Integer loginCount;
    private String email;
    private String info;
    /**
     * 并发症
     */
    private String complication;
}
