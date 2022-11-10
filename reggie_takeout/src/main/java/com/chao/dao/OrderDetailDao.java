package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */
@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {
}
