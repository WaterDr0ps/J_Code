package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.dto.DishDto;
import com.chao.entity.Dish;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */
@Transactional(rollbackFor = Exception.class)
public interface DishService extends IService<Dish> {
    /**
     * 保存菜品信息，并且向flavors表添加口味
     * @param dishDto
     */
    void saveWithFlavors(DishDto dishDto);

    /**
     * 通过id查数据，并查询口味
     * @param id
     */
    DishDto getByIdWithFlavors(Long id);

    /**
     * 修改菜品信息，并且向flavors表修改口味
     * @param dishDto
     */
    void updateWithFlavors(DishDto dishDto);
}
