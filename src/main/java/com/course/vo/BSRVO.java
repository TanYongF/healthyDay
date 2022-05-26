package com.course.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
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
public class BSRVO {

    private Long userId;

    @Digits(integer = 1, fraction = 4)
    @Max(8)
    @Min(3)
    @NotNull
    private BigDecimal value;

    @Past
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

}
