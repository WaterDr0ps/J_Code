package com.chao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.common.Result;
import com.chao.dto.DishDto;
import com.chao.entity.Category;
import com.chao.entity.Dish;
import com.chao.entity.DishFlavor;
import com.chao.service.CategoryService;
import com.chao.service.DishFlavorService;
import com.chao.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eliot
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategoryService categoryService;



    /**
     * 分页查询
     * @param page 当前页
     * @param pageSize 页大小
     * @param name 检索名
     * @return
     */
    @GetMapping("/page")
    public Result<Page<DishDto>> pageQuery(int page,int pageSize,String name){
        Page<Dish> pageInfo = new Page<>(page,pageSize);
        //新建dishDto泛型对象，用于获取菜品分类数据，=pageInfo里内容 + 菜品分类
        Page<DishDto> dishDtoPage = new Page<>();

        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //注意搜索栏名称不为空时才检索
        queryWrapper.like(name!=null,Dish::getName,name);
        queryWrapper.orderByDesc(Dish::getUpdateTime);

        dishService.page(pageInfo,queryWrapper);

        //对象拷贝，不需要records是因为泛型不同
        BeanUtils.copyProperties(pageInfo,dishDtoPage,"records");
        //查出dish里的全部记录
        List<Dish> records = pageInfo.getRecords();

        List<DishDto> list = records.stream().map(item -> {
            //新建dishDto用于接收拷贝记录
            DishDto dishDto = new DishDto();
            //单条记录拷贝
            BeanUtils.copyProperties(item, dishDto);
            //获取id值并通过categoryService查出 菜品分类
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            assert category != null;
            //最后将菜品分类字段追加
            dishDto.setCategoryName(category.getName());
            return dishDto;
        }).collect(Collectors.toList());
        //将流中包装后的集合记录赋给分页dishDtoPage
        dishDtoPage.setRecords(list);

        return Result.success(dishDtoPage);
    }

    /**
     * 添加菜品
     * @param dishDto 通过dto封装页面数据
     * @return
     */
    @PostMapping
    public Result<String> save(@RequestBody DishDto dishDto){
        dishService.saveWithFlavors(dishDto);
        return Result.success("成功");
    }

    /**
     * 通过id回显数据，需要两张表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DishDto> getByIdWithFlavors(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdWithFlavors(id);
        return Result.success(dishDto);
    }

    /**
     * 更新菜品
     * @param dishDto 通过dto封装页面数据
     * @return
     */
    @PutMapping
    public Result<String> update(@RequestBody DishDto dishDto){
        dishService.updateWithFlavors(dishDto);
        return Result.success("修改成功");
    }

    /**
     * 显示数据
     * @param dish 用于接收categoryId
     * @return
     */
    @GetMapping("/list")
    public Result<List<DishDto>> list(Dish dish){
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId()!=null, Dish::getCategoryId,dish.getCategoryId())
                .eq(Dish::getStatus,1)
                .orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);

        List<DishDto> dishDtoList = list.stream().map(item -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);

            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if(category != null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }

            Long id = item.getId();
            LambdaQueryWrapper<DishFlavor> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(DishFlavor::getDishId, id);
            List<DishFlavor> list1 = dishFlavorService.list(queryWrapper1);
            dishDto.setFlavors(list1);
            return dishDto;
        }).collect(Collectors.toList());

        return Result.success(dishDtoList);
    }
}












