package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Describe 用户积分实体类
 * @Author tyf
 * @CreateTime 2022/5/11
 * @Comment 测试
 * @
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Points implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private Integer id;
    //成长积分数
    private Integer growScore;
    //可兑换积分数
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;
}
