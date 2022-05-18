package com.course.vo;

import com.course.validator.IsMobile;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

/**
 * @describe: 用户个人信息实体
 * @author: tyf
 * @createTime: 2022/5/18 09:50
 **/
@Data
@NoArgsConstructor
public class UserInfoVO {

    @IsMobile
    @NotBlank
    private String id;
    private String nickname;
    private Byte gender;
    private String head;
    private String email;
    private String info;
    /**
     * 并发症
     */
    private String complication;
}
