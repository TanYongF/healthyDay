package com.course.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @describe: 用户积分记录表，用户的积分行为会记录在这里
 * @author: tyf
 * @createTime: 2022/5/16 14:21
 **/
@Data
@NoArgsConstructor
public class CreditTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 事件id
     */
    private Long eventId;

    /**
     * create_time
     */
    private LocalDateTime createTime;

    /**
     * expired_time
     */
    private LocalDateTime expiredTime;

}