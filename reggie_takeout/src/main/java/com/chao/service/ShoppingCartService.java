package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.ShoppingCart;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */
@Transactional(rollbackFor = Exception.class)
public interface ShoppingCartService extends IService<ShoppingCart> {
}
