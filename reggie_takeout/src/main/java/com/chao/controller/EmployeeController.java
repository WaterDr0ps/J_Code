package com.chao.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.common.Result;
import com.chao.entity.Employee;
import com.chao.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Eliot
 */

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登陆
     * @param request 将用户存储在Session
     * @param employee 获取页面请求体对象
     * @return
     */
    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request , @RequestBody Employee employee){
        //密码使用md5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据用户名查数据
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //判断用户名是否存在
        if(emp == null){
            return Result.error("用户名错误，登陆失败");
        }

        //判断密码是否正确
        if(!emp.getPassword().equals(password)){
            return Result.error("密码错误，登陆失败");
        }

        //判断用户被禁用
        if(emp.getStatus()==0){
            return Result.error("账户被禁用");
        }
        //用户没有被禁用,成功登陆并将id存储session
        request.getSession().setAttribute("employee",emp.getId());
        return Result.success(emp);
    }

    /**
     * 退出登录
     * @param request 将Session里用户删除
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return Result.success("退出成功");
    }

    /**
     * 新增员工
     * @param request 用于设置创建者和修改者
     * @param employee 获取emp对象
     * @return
     */
    @PostMapping
    public Result<String> addEmployee(@RequestBody Employee employee){
        //设置初始密码
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        //添加
        employeeService.save(employee);

        return Result.success("添加成功");
    }

    /**
     * 分页查询
     * @param page 当前页
     * @param pageSize 每页大小
     * @param name 搜索名
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Employee>> pageQuery(int page,int pageSize,String name){
        //构造分页构造器
        Page<Employee> pageInfo = new Page<>(page,pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件,姓名不为空执行
        lambdaQueryWrapper.like(name!=null,Employee::getName,name);
        //添加排序条件
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        //执行查询
        employeeService.page(pageInfo,lambdaQueryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 更新数据
     * @param employee 获取emp对象
     * @return
     */
    @PutMapping
    public Result<String> update(@RequestBody Employee employee){
        employeeService.updateById(employee);

        return Result.success("修改成功");
    }

    /**
     * 通过id查询
     * @param id url参数获取id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Employee> queryEmployeeById(@PathVariable Long id){
        Employee emp = employeeService.getById(id);
        return Result.success(emp);
    }

}










