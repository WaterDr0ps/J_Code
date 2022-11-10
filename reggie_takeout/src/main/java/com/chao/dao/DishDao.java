package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */
@Mapper
public interface DishDao extends BaseMapper<Dish> {
}
