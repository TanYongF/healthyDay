package com.course.dao;

import com.course.pojo.BloodSugarRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @describe: 类描述
 * @author: tyf
 * @createTime: 2022/5/14 12:21
 **/
@Mapper
public interface BSRDao {

    /**
     * 返回用户ID 为 userId的记录
     *
     * @param useId 用户Id
     * @return 结果集
     */
    @Select("select * from blood_sugar_record where user_id = #{userId}")
    List<BloodSugarRecord> getById(Long useId);


    /**
     * 插入血糖记录
     *
     * @param bsr 传入记录
     */
    @Insert("insert into blood_sugar_record(user_id, value, record_time) values (#{userId}, #{value}," +
            "#{recordTime})")
    void insert(BloodSugarRecord bsr);

}
