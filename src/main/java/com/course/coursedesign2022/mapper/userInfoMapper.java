package com.course.coursedesign2022.mapper;

import com.course.coursedesign2022.pojo.userInfo;
import com.course.coursedesign2022.pojo.userInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userInfoMapper {
    long countByExample(userInfoExample example);

    int deleteByExample(userInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    List<userInfo> selectByExample(userInfoExample example);

    userInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByExample(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}