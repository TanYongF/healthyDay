package com.course.vo;

import com.course.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @describe: 用户信息表示层，用户的信息会封装在这里
 * @author: tyf
 * @createTime: 2022/5/16 14:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private User details;
    /**
     * 用户成长积分
     */
    private long growScore;
    /**
     * 生效可兑换积分
     */
    private long effectiveExchangeScore;
    /**
     * 失效可兑换积分
     */
    private long invalidExchangeScore;
}
