package com.course.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Describe 胰岛素记录表
 * @Author tyf
 * @CreateTime 2022/5/11
 * @Comment 测试
 * @
 **/
@NoArgsConstructor
@Data
public class InsulinRecord {

    private long id;
    private String userId;
    private BigDecimal value;
    private LocalDateTime recordTime;
}
