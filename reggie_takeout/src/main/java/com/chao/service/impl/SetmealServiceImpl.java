package com.chao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.SetmealDao;
import com.chao.dto.SetmealDto;
import com.chao.entity.Setmeal;
import com.chao.entity.SetmealDish;
import com.chao.exception.BusinessException;
import com.chao.service.SetmealDishService;
import com.chao.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eliot
 */

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存基本的套餐数据
        this.save(setmealDto);

        //取出套餐菜品信息，遍历存表,依次给setmealId赋值(雪花算法在新建时自动创建，需要赋值)
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map(item->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        setmealDishService.saveBatch(setmealDishes);
    }

    @Override
    public void removeWithDish(List<Long> ids) {
        //删除套餐
        LambdaQueryWrapper<Setmeal> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.in(Setmeal::getId,ids)
                .eq(Setmeal::getStatus,"1");
        int count = this.count(queryWrapper1);
        if(count>0){
            throw new BusinessException("套餐还在售卖，无法删除");
        }
        this.removeByIds(ids);

        //删除菜品
        LambdaQueryWrapper<SetmealDish> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(queryWrapper2);
    }
}
