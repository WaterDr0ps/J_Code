package com.chao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.CategoryDao;
import com.chao.entity.Category;
import com.chao.entity.Dish;
import com.chao.entity.Setmeal;
import com.chao.exception.BusinessException;
import com.chao.service.CategoryService;
import com.chao.service.DishService;
import com.chao.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setMealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        dishQueryWrapper.eq(Dish::getCategoryId, id);
        int dishCount = dishService.count(dishQueryWrapper);
        //如果关联菜品了，需要抛出业务异常
        if (dishCount > 0) {
            throw new BusinessException("删除失败，当前类别下还有菜品");
        }

        LambdaQueryWrapper<Setmeal> setMealQueryWrapper = new LambdaQueryWrapper<>();
        setMealQueryWrapper.eq(Setmeal::getCategoryId, id);
        int setMealCount = setMealService.count(setMealQueryWrapper);
        //如果关联套餐，需要抛出业务异常
        if (setMealCount > 0) {
            throw new BusinessException("删除失败，当前类别下还有套餐");
        }

        super.removeById(id);
    }
}










