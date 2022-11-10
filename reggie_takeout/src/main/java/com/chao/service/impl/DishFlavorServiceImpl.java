package com.chao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.DishFlavorDao;
import com.chao.entity.DishFlavor;
import com.chao.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorService {
}
