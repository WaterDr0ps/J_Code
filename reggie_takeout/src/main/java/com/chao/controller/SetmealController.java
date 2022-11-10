package com.chao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.common.Result;
import com.chao.dto.SetmealDto;
import com.chao.entity.Category;
import com.chao.entity.Setmeal;
import com.chao.service.CategoryService;
import com.chao.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author Eliot
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加套餐，需要关联套餐和套餐菜品两张表
     * @param setmealDto 页面封装的数据
     * @return
     */
    @PostMapping
    public Result<String> saveWithDish(@RequestBody SetmealDto setmealDto){
        setmealService.saveWithDish(setmealDto);
        return Result.success("添加成功");
    }

    /**
     * 分页查询<br/>
     * 需要套餐分类字段值，需要dto泛型的分页构造器
     * @param page 当前页
     * @param pageSize 每页大小
     * @param name 检索名
     * @return dto
     */
    @GetMapping("/page")
    public Result<Page<SetmealDto>> pageQuery(int page,int pageSize,String name){
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPageInfo = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Setmeal::getName,name)
                .orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        BeanUtils.copyProperties(pageInfo,dtoPageInfo,"records");

        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map(setmeal -> {
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(setmeal,setmealDto);

            Long categoryId = setmeal.getCategoryId();
            Category category = categoryService.getById(categoryId);
            assert category!=null;

            setmealDto.setCategoryName(category.getName());

            return setmealDto;
        }).collect(Collectors.toList());

        dtoPageInfo.setRecords(list);

        return Result.success(dtoPageInfo);
    }

    /**
     * 根据ids删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result<String> deleteById(@RequestParam List<Long> ids){
        setmealService.removeWithDish(ids);
        return Result.success("删除成功");
    }

    /**
     * 修改套餐售卖状态
     * @param status 0-禁售 1-启售
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public Result<String> setStatus(@PathVariable int status,@RequestParam List<Long> ids)  {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        List<Setmeal> list = setmealService.list(queryWrapper);

        list = list.stream().map(setmeal -> {
            Setmeal newSetmeal = new Setmeal();
            BeanUtils.copyProperties(setmeal, newSetmeal);
            if (status == 0) {
                newSetmeal.setStatus(0);
            } else {
                newSetmeal.setStatus(1);
            }
            return newSetmeal;
        }).collect(Collectors.toList());

        setmealService.updateBatchById(list);

        return Result.success("操作成功");
    }

    /**
     * 查询
     * @param setmeal 用于接收categoryId和status
     * @return
     */
    @GetMapping("/list")
    public Result<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId()!=null,Setmeal::getCategoryId,setmeal.getCategoryId())
                .eq(setmeal.getStatus()!=null,Setmeal::getStatus,setmeal.getStatus())
                .orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setmealService.list(queryWrapper);

        return Result.success(list);
    }
}
















