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
    @Select("\n" +
            "select record_time , value\n" +
            "from insulin_record ir \n" +
            "where user_id = #{userId} and to_days(now()) - to_days(record_time) <= #{days};\n" +
            "\n")
    List<InsulinRecord> getById(Long userId, int days);


    /**
     * 插入胰岛素记录
     *
     * @param inr 传入记录
     */
    @Insert("insert into insulin_record(user_id, value, record_time) values (#{userId}, #{value}," +
            "#{recordTime})")
    void insert(InsulinRecord inr);
}
