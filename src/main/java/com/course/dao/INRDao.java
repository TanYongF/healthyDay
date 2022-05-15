package com.course.dao;

import com.course.pojo.InsulinRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @describe: 胰岛素填报接口
 * @author: tyf
 * @createTime: 2022/5/15 10:20
 **/
@Mapper
public interface INRDao {


    /**
     * 返回用户ID 为 userId的记录
     *
     * @param userId 用户Id
     * @return 结果集
     */
    @Select("select * from insulin_record where user_id = #{userId}")
    List<InsulinRecord> getById(Long userId);


    /**
     * 插入胰岛素记录
     *
     * @param inr 传入记录
     */
    @Insert("insert into insulin_record(user_id, value, record_time) values (#{userId}, #{value}," +
            "#{recordTime})")
    void insert(InsulinRecord inr);
}
