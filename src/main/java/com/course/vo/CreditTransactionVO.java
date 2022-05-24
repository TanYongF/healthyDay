package com.course.vo;

import com.alibaba.druid.filter.AutoLoad;
import com.course.pojo.CreditTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @describe: 积分记录展示类
 * @author: tyf
 * @createTime: 2022/5/24 09:08
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransactionVO {
    private LocalDateTime createTime;
    private LocalDateTime expiredTime;
    private String  info;
    private Integer points;
    private Integer effectiveDay;
}
