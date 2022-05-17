package com.course.service;

import com.course.dao.CreditTransactionDao;
import com.course.pojo.User;
import com.course.vo.UserDTO;
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

    public UserDTO getUserDetails(Long userId) {
        UserDTO userDTO = creditTransactionDao.getCreditByUserId(userId);
        User userDetails = userService.getById(userId);
        userDetails.setPassword("********");
        userDetails.setSalt("***********");
        userDTO.setDetails(userDetails);
        return userDTO;
    }




}
