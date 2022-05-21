package com.course.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @describe: 前端传入的表单对应实体
 * @author: tyf
 * @createTime: 2022/5/14 12:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class INRVO {

    private Long userId;

    @Digits(integer = 1, fraction = 2)
    private BigDecimal value;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

}
