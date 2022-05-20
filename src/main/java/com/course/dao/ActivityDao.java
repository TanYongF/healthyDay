package com.course.dao;

import com.course.pojo.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @describe: 类描述
 * @author: tyf
 * @createTime: 2022/5/20 16:22
 **/
@Mapper
@Repository
public interface ActivityDao {

    @Select("select * from activity where id=#{id}")
    public Activity getById(Long id);

    @Options(useGeneratedKeys=true,keyProperty="activityId")
    @Insert("insert into activity" +
            " (id,info,dead_date,event_id,organiser,address,page_photo)" +
            " values(id,info,deadDate,eventId,organiser,address,pagePhoto)")
    public Integer insert(Activity activity);

    @Delete(value = "delete from activity where id=#{activityId}")
    boolean delete(Integer id);

    @Update(value = "update activity set "

            +" info=#{info},"
            +" dead_date=#{deadDate},"
            +" event_id=#{eventId},"
            +" organiser=#{organiser},"
            +" address=#{address},"
            +" page_photo=#{pagePhoto}"
            +" where id=#{activityId} ")
    boolean update(Activity activity);


    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "deadDate", column = "dead_date"),
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "organiser", column = "organiser"),
            @Result(property = "address", column = "address"),
            @Result(property = "pagePhoto", column = "page_photo")
    })
    @Select(value = "select * from activity where id=#{queryParam}")
    Activity selectOne(String queryParam);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "deadDate", column = "dead_date"),
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "organiser", column = "organiser"),
            @Result(property = "address", column = "address"),
            @Result(property = "pagePhoto", column = "page_photo")
    })
    @Select(value = "select * from activity where "
            +" id=#{id} or "
            +" info=#{info} or "
            +" dead_date=#{deadDate} or "
            +" event_id=#{eventId} or "
            +" organiser=#{organiser} or "
            +" address=#{address} or "
            +" page_photo=#{pagePhoto}"
    )
    List<Activity> selectList(Activity activity);

}