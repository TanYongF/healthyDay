package com.course.coursedesign2022.mapper;

import com.course.coursedesign2022.pojo.PointObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
//mybatis的mapper接口
@Mapper
@Repository
public interface UserMapper {
    //查询所有用户
    List<PointObject> getPointObject();
    //根据ID查询用户
    PointObject getPointObjectByID(int id);
    //insert一个用户,增删改需要提交事务
    int addPointObject(PointObject pointObject);
    //更新数据
    int updatePointObject(PointObject pointObject);
    //删除用户
    int deletePointObject(int id);
}
