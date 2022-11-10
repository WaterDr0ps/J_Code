package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.Orders;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    void submit(Orders orders);
}
