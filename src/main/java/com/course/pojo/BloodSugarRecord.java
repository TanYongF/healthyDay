package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Describe 血糖记录表
 * @Author tyf
 * @CreateTime 2022/5/11
 * @Comment 测试
 * @
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BloodSugarRecord {

    private static final long serialVersionUID = 123456789L;
    private long id;
    private String userId;
    private BigDecimal value;
    private LocalDateTime recordTime;
}
