package com.chao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.common.Result;
import com.chao.entity.Orders;
import com.chao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eliot
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public Result<String> submit(@RequestBody Orders orders){
        orderService.submit(orders);
        return Result.success("成功");
    }

    @GetMapping("/userPage")
    public Result<Page<Orders>> pageQuery(int page,int pageSize){
        Page<Orders> pageInfo = new Page<>(page,pageSize);

        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Orders::getOrderTime);

        orderService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }
}
