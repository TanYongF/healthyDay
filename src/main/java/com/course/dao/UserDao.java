package com.course.dao;

import com.course.pojo.User;
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

    @Select("select * from miaosha_user user where id = #{id}")
    public User getById(long id);

    @Update("update miaosha_user set password = #{password} where id = #{id}")
    void update(User toBeUpdate);
}
