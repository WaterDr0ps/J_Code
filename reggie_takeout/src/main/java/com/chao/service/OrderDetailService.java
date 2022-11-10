package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.OrderDetail;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface OrderDetailService extends IService<OrderDetail> {

}
