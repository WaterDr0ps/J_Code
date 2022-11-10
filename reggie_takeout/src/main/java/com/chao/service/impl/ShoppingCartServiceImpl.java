package com.chao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.ShoppingCartDao;
import com.chao.entity.ShoppingCart;
import com.chao.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartDao, ShoppingCart> implements ShoppingCartService {
}
