package com.chao.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eliot
 */
@Repository
public interface BankUserDao {
    @Update("update bank_user set money=money+#{money} where name=#{name}")
    void saveMoney(@Param("name") String name, @Param("money") int money);

    @Update("update bank_user set money=money-#{money} where name=#{name}")
    void takeMoney(@Param("name") String name, @Param("money") int money);

}
