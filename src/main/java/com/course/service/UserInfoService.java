package com.course.service;

import com.course.dao.CreditTransactionDao;
import com.course.dao.UserDao;
import com.course.pojo.User;
import com.course.vo.UserDTO;
import com.course.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe: 用户信息Service
 * @author: tyf
 * @createTime: 2022/5/16 14:23
 **/
@Service
public class UserInfoService {

    @Autowired
    CreditTransactionDao creditTransactionDao;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    /**
     * @author tyf
     * @description 获取用户基本信息
     * @date 11:43 2022/5/18
     **/
    public UserDTO getUserDetails(Long userId) {
        UserDTO userDTO = creditTransactionDao.getCreditByUserId(userId);
        User userDetails = userService.getById(userId);
        //密码隐藏
        userDetails.setPassword("********");
        userDetails.setSalt("***********");
        userDTO.setDetails(userDetails);
        return userDTO;
    }

    /**
     * @author tyf
     * @description 更新用户基本信息
     * @date 11:42 2022/5/18
     **/
    public void updateInfo(UserInfoVO userInfoVO) {
        User toBeUpdate = userService.getById(Long.parseLong(userInfoVO.getId()));
        toBeUpdate.setEmail(userInfoVO.getEmail());
        toBeUpdate.setInfo(userInfoVO.getInfo());
        toBeUpdate.setGender(userInfoVO.getGender());
        toBeUpdate.setHead(userInfoVO.getHead());
        toBeUpdate.setNickname(userInfoVO.getNickname());
        userService.updateInfo(toBeUpdate);
    }

    /**
     * @author tyf
     * @description 更新用户并发症
     * @date 11:42 2022/5/18
     **/
    public void updateComplication(UserInfoVO userInfoVO) {
        User toBeUpdate = userService.getById(Long.parseLong(userInfoVO.getId()));
        toBeUpdate.setComplication(userInfoVO.getComplication());
        userService.updateInfo(toBeUpdate);
    }
}
