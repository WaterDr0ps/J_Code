package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.dto.SetmealDto;
import com.chao.entity.Setmeal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Eliot
 */
@Transactional(rollbackFor = Exception.class)
public interface SetmealService extends IService<Setmeal> {
    /**
     * 保存套餐，同时保存菜品和套餐关系
     * @param setmealDto 封装的组合数据
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 根据ids删除，同时需要将菜品和套餐关系删除
     * @param ids
     */
    void removeWithDish(List<Long> ids);
}
