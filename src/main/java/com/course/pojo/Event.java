package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @describe: 事件类
 * @author: tyf
 * @createTime: 2022/5/16 14:24
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Event {


    private long id;
    /**
     * 事件概述
     */
    private String info;
    /**
     * 事件类型 1：成长积分 0：可兑换积分
     */
    private byte type;
    /**
     * 积分点数
     */
    private int points;


}