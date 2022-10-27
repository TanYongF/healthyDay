package com.course.service;

import com.course.dao.CreditTransactionDao;
import com.course.dao.UserDao;
import com.course.pojo.User;
import com.course.vo.CreditTransactionDTO;
import com.course.vo.UserDTO;
import com.course.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
     *
     * @param userId 用户ID
     * @return 用户展示实体（敏感信息脱敏1）
     */
    public UserDTO getUserDetails(Long userId) {
        UserDTO userDTO = creditTransactionDao.getCreditByUserId(userId);
        User userDetails = userService.getById(userId);
        //敏感信息脱敏
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
     * 更新用户头像
     * @param user 用户鉴权实体
     * @param file 头像文件
     */
    public void updateAvatar(User user, MultipartFile file){
        String savePath = "";
        try {
            //TODO:该部分之后要上传OSS上
            //生成一个uuid名称出来
            String uuidFilename = UUID.randomUUID().toString();
            //产生一个随机目录
            String randomDir = "/pic";
            File fileDir = new File("D:/uploadfiles" + randomDir);
            //若文件夹不存在,则创建出文件夹
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            //创建新的文件夹
            File newFile = new File("D:/uploadfiles" + randomDir, uuidFilename);
            //将文件输出到目标的文件中
            file.transferTo(newFile);
            //将保存的文件路径更新到用户信息avatar中
            savePath = randomDir + "/" + uuidFilename;
        }catch (IOException e){
            e.printStackTrace();
        }
        //设置头像图片路径
        user.setHead(savePath);
        //调用业务更新user
        userService.updateInfo(user);
    }

    /**
     * 更新用户并发症信息
     * @param userInfoVO 用户信息更新实体
     */
    public void updateComplication(UserInfoVO userInfoVO) {
        User toBeUpdate = userService.getById(Long.parseLong(userInfoVO.getId()));
        toBeUpdate.setComplication(userInfoVO.getComplication());
        userService.updateInfo(toBeUpdate);
    }

    public List<CreditTransactionDTO> getCreditRecordByType(Long userId, Byte type) {
        List<CreditTransactionDTO> recordById = creditTransactionDao.getCreditRecordByIdAndType(userId, type);
        return recordById;
    }
}
