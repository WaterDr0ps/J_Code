package com.chao.dao;

import com.chao.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    void add(User user);

    @Delete("delete from users where id=#{id}")
    void deleteById(int id);

    @Update("update users set name=#{name},age=#{age},gender=#{gender},phone=#{phone},address=#{address} where id=#{id}")
    void update(User user);
}
