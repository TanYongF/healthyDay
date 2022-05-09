package com.course.service;

import com.alibaba.druid.util.StringUtils;
import com.course.dao.UserDao;
import com.course.exception.GlobalException;
import com.course.exception.LoginException;
import com.course.pojo.User;
import com.course.redis.RedisService;
import com.course.redis.UserKey;
import com.course.result.CodeMsg;
import com.course.utils.MD5Util;
import com.course.utils.UUIDUtil;
import com.course.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/

@Service
public class UserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;


    public User getById(long id) {

        //取缓存
        User user = redisService.get(UserKey.getById, id + "", User.class);
        if (user != null) {
            return user;
        }
        user = userDao.getById(id);

        /*加载到缓存中*/
        if (user != null) {
            redisService.set(UserKey.getById, id + "", user);
        }
        return user;
    }

    public boolean isAuth(String token) {
        //取缓存
        boolean exists = redisService.exists(UserKey.token, token);
        return exists;
    }

    /**
     * 更新用户密码接口
     *
     * @param id           用户id
     * @param formPassword 用户表单密码
     * @param token        用户token
     * @return 是否更改成功
     */
    public boolean updatePassword(long id, String formPassword, String token) {
        User user;
        if ((user = userDao.getById(id)) == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }

        //update the data in database
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDbPass(formPassword, user.getSalt()));
        userDao.update(toBeUpdate);

        //remove the data in redis
        redisService.remove(UserKey.getById, id + "");

        //update the token in redis
        user.setPassword(toBeUpdate.getPassword());
        redisService.set(UserKey.token, token, user.getPassword());
        return true;
    }

    public boolean login(LoginVo loginVo, HttpServletResponse response) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        //检验用户
        String mobile = loginVo.getMobile();
        User user = getById(Long.parseLong(mobile));

        if (user == null) {
            throw new LoginException(CodeMsg.MOBILE_NOT_EXIST, loginVo);
        }

        String formPass = loginVo.getPassword();
        String dbPass = MD5Util.formPassToDbPass(formPass, user.getSalt());
        if (!dbPass.equals(user.getPassword())) {
            throw new LoginException(CodeMsg.PASSWORD_ERROR, loginVo);
        }
        String token = UUIDUtil.uuid();
        addCookie(response, user, token);
        return true;
    }

    private void addCookie(HttpServletResponse response, User user, String token) {
        if (user == null || StringUtils.isEmpty(token)) return;
        //生成Cookie
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获取用户token并将其token更新
     *
     * @param response
     * @param token
     * @return
     */
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(UserKey.token, token, User.class);

        //更新token有效期
        addCookie(response, user, token);
        return user;
    }
}
