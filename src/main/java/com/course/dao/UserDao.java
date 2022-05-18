package com.course.dao;

import com.course.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/5/6
 **/

@Mapper
public interface UserDao {

    @Select("select * from user user where id = #{id}")
    User getById(long id);

    /**
     * 更新密码接口
     * @param toBeUpdate
     */
    @Update("update user set password = #{password} where id = #{id}")
    void updatePassword(User toBeUpdate);

    @Insert("insert into user (id, salt, password, register_date, login_count) values " +
            "(#{id}, #{salt}, #{password}, #{registerDate}, #{loginCount})")
    void insert(User user);

    /**
     * 更新用户最后登陆日期
     *
     * @param toBeUpdate 用户实体
     */
    @Update("update user set last_login_date = #{lastLoginDate} where id = #{id}")
    void updateLastLoginDate(User toBeUpdate);

    /**
     * 更新用户基本信息
     *
     * @param toBeUpdate 待更新信息
     */
    @Update("update user set head = #{head}, info = #{info}, email = #{email}, nickname = #{nickname}," +
            "gender= #{gender}, complication = #{complication}  where id =#{id}")
    void updateInfo(User toBeUpdate);

}
