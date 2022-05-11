package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Describe: 活动表
 * @Author: tyf
 * @CreateTime: 2022/5/11
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityRecord {

    private Long id;
    private Long userId;
    private String info;
    private Date date;
    private Integer type;

}