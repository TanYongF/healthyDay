package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

/**
 * @describe: 事件类
 * @author: tyf
 * @createTime: 2022/5/16 14:24
 **/
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Event {

    public static final Event DAILY_LOGIN_RECORD = new Event(201L, "用户每日登陆", 0);
    public static final Event UPDATE_BSR_RECORD = new Event(202L, "填报血糖含量", 0);
    public static final Event UPDATE_INR_RECORD = new Event(203L, "填报胰岛素含量", 0);
    public static final Event UPDATE_USER_DETAIL = new Event(204L, "完善用户信息", 0);
    public static final Event UPDATE_USER_COMPLICATION = new Event(205L, "完善用户并发症信息", 0);
    public static final Event JOIN_SCIENCE_JOB = new Event(301L, "参加科研活动", 60);
    public static final Event JOIN_SUI_FANG = new Event(302L, "完成门诊随访", 60);
    public static final Event JOIN_OTHER_ACTIVITY = new Event(303L, "参加拓展活动", 60);
    public static HashMap<Long, Event> eventMap = new HashMap();

    static {
        eventMap.put(201L, DAILY_LOGIN_RECORD);
        eventMap.put(202L, UPDATE_BSR_RECORD);
        eventMap.put(203L, UPDATE_INR_RECORD);
        eventMap.put(204L, UPDATE_USER_DETAIL);
        eventMap.put(205L, UPDATE_USER_COMPLICATION);
        eventMap.put(301L, JOIN_SCIENCE_JOB);
        eventMap.put(302L, JOIN_SUI_FANG);
        eventMap.put(303L, JOIN_OTHER_ACTIVITY);
    }


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

    /**
     * 生效时长， 单位 day
     */
    private long effectiveDay;

    /**
     * 每日最大次数
     */
    private int maxFrequencyPerDay;

    /**
     * 每月最大次数
     */
    private int maxFrequencyPerMonth;

    /**
     * 每年最大次数
     */
    private int maxFrequencyPerYear;

    public Event(long id, String info, long effectiveDay) {
        this.info = info;
        this.id = id;
        this.effectiveDay = effectiveDay;
    }

    @Override
    public String toString() {
        return "Event(" +
                "id=" + id +
                ",\"" + info + "\"" +
                "," + type +
                "," + points +
                "," + effectiveDay +
                "," + maxFrequencyPerDay +
                "," + maxFrequencyPerMonth +
                "," + maxFrequencyPerYear +
                ')';
    }
}