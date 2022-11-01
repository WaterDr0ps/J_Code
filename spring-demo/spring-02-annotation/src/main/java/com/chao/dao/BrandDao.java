package com.chao.dao;

import com.chao.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eliot
 */
@Repository
public interface BrandDao {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);


}
