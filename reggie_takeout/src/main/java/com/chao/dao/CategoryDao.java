package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
