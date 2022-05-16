package com.course.dao;

import com.course.pojo.CreditTransaction;
import com.course.vo.UserDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @describe: 积分持久层接口
 * @author: tyf
 * @createTime: 2022/5/16 14:23
 **/
@Mapper
@Repository
public interface CreditTransactionDao {

    @Select("select * from credit_transaction where credit_transaction_id=#{id}")
    public CreditTransaction getById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "creditTransactionId")
    @Insert("insert into credit_transaction" +
            " (id,user_id,event_id,create_time,expired_time)" +
            " values(id,userId,eventId,createTime,expiredTime)")
    public Integer insert(CreditTransaction creditTransaction);

    @Delete(value = "delete from credit_transaction where credit_transaction_id=#{creditTransactionId}")
    boolean delete(Integer id);

    @Update(value = "update credit_transaction set "

            + " user_id=#{userId},"
            + " event_id=#{eventId},"
            + " create_time=#{createTime},"
            + " expired_time=#{expiredTime}"
            + " where credit_transaction_id=#{creditTransactionId} ")
    boolean update(CreditTransaction creditTransaction);


    /**
     * 根据用户ID来获取用户的三种积分；
     *
     * @param userId 用户id
     * @return
     */
    @Select("select \n" +
            "ifnull(sum(case temp.type when '0' then temp.points else 0 end),0) as `grow_score`,\n" +
            "ifnull(sum(case temp.type when '1' then temp.points else 0 end),0) as `effective_exchange_score`,\n" +
            "(select ifnull(sum(points),0)\n" +
            "\tfrom credit_transaction ct1 left join event ev1 on ct1.event_id = ev1.id\n" +
            "\twhere user_id = #{userId} and ev1.type = 1 and datediff(ct1.expired_time, now()) < 0\n" +
            ") as `invalid_exchange_score`\n" +
            "from\n" +
            "(select ev.type, sum(points) as points \n" +
            "from (credit_transaction ct left join event ev on ct.event_id = ev.id)\n" +
            "where user_id = #{userId} and if(ev.type = 1 and datediff(date(expired_time), CURDATE()) < 0, false, " +
            "true)\n" +
            "group by `type`) as temp\n")
    UserDTO getCreditByUserId(Long userId);


    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "expiredTime", column = "expired_time")
    })
    @Select(value = "select * from credit_transaction where credit_transaction_id=#{queryParam}")
    CreditTransaction selectOne(String queryParam);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "expiredTime", column = "expired_time")
    })
    @Select(value = "select * from credit_transaction where "
            + " id=#{id} or "
            + " user_id=#{userId} or "
            + " event_id=#{eventId} or "
            + " create_time=#{createTime} or "
            + " expired_time=#{expiredTime}"
    )
    List<CreditTransaction> selectList(CreditTransaction creditTransaction);

}