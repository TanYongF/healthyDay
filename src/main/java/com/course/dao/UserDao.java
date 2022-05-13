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

    @Update("update user set password = #{password} where id = #{id}")
    void update(User toBeUpdate);

    @Insert("insert into user (id, salt, password, register_date, login_count) values " +
            "(#{id}, #{salt}, #{password}, #{registerDate}, #{loginCount})")
    void insert(User user);

}
