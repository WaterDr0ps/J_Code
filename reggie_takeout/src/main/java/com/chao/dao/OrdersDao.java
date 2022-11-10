package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */
@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
}
