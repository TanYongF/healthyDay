package com.course.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Describe: 活动表
 * @Author: tyf
 * @CreateTime: 2022/5/11
 **/
@Data
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 活动简介
     */
    private String info;

    /**
     * 活动时间
     */
    private Date deadDate;

    /**
     * 触发事件积分
     */
    private Long eventId;

    /**
     * 举办企业
     */
    private String organiser;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 主题图片
     */
    private String pagePhoto;

    public Activity() {}
}