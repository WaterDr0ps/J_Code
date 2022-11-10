package com.chao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.common.Result;
import com.chao.entity.Category;
import com.chao.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Eliot
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Category>> pageQuery(int page,int pageSize){
        //构造分页构造器
        Page<Category> pageInfo = new Page<>(page,pageSize);
        //添加排序条件
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Category::getSort);

        categoryService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 新增分类
     * @param request 获取创建修改者id
     * @param category
     * @return
     */
    @PostMapping
    public Result<String> save(@RequestBody Category category){
        categoryService.save(category);

        return Result.success("添加成功");
    }

    /**
     * 更新分类
     * @param category
     * @param request
     * @return
     */
    @PutMapping
    public Result<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return Result.success("修改成功");
    }

    /**
     * 根据id删除
     * @param id 删除对象id
     * @return
     */
    @DeleteMapping
    public Result<String> deleteById(Long ids){
        categoryService.remove(ids);
        return Result.success("删除成功");

    }

    /**
     * 查所有类别
     * @param category
     * @return
     */
    @GetMapping("/list")
    public Result<List<Category>> listType(Category category){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);
        return Result.success(list);
    }
}









