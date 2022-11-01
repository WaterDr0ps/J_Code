package com.chao.dao;

import com.chao.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eliot
 */
@Repository
public interface UserDao {
    @Select("select * from users")
    List<User> selectAll();

    @Insert("insert into users values (null,#{name},#{age},#{gender},#{phone},#{address})")
    int add(User user);

    @Delete("delete from users where id=#{id}")
    int deleteById(int id);

    @Update("update users set name=#{name},age=#{age},gender=#{gender},phone=#{phone},address=#{address} where id=#{id}")
    int update(User user);

    @Select("select * from users limit #{currentPage},#{pageSize}")
    List<User> pageQuery(@Param("currentPage") int currentPage, @Param("pageSize")int pageSize);

    @Select("select count(*) from users")
    int selectTotal();
}
