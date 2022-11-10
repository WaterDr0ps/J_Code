package com.chao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.DishDao;
import com.chao.dto.DishDto;
import com.chao.entity.Dish;
import com.chao.entity.DishFlavor;
import com.chao.service.DishFlavorService;
import com.chao.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eliot
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishDao, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    @Override
    public void saveWithFlavors(DishDto dishDto) {
        //先保存基本信息到dish
        this.save(dishDto);

        //添加后，通过雪花算法自动生成id，此时需要获取id依次赋值
        Long dishId = dishDto.getId();

        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(item ->{
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithFlavors(Long id) {
        //基本dish数据
        Dish dish = this.getById(id);

        //封装的DishDto对象
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //flavors口味数据
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> list = dishFlavorService.list(queryWrapper);

        //flavors封装回dishDto
        dishDto.setFlavors(list);

        return dishDto;
    }

    @Override
    public void updateWithFlavors(DishDto dishDto) {
        //更新基本数据
        this.updateById(dishDto);

        //清除flavors口味数据
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        //重新设置flavors
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(item->{
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }
}
