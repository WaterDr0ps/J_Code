package com.chao.controller;

import com.chao.exception.BusinessException;
import com.chao.exception.SystemException;
import com.chao.pojo.PageBean;
import com.chao.pojo.User;
import com.chao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通过Result封装数据,与前端交互
 * @author Eliot
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result selectAll(){
        List<User> users = userService.selectAll();
        Integer code=users!=null?Code.SELECT_OK:Code.SELECT_ERR;
        return new Result(code,users);
    }

    @PostMapping
    public Result add(@RequestBody User user){
        boolean flag = userService.add(user);
        Integer code=flag?Code.ADD_OK:Code.ADD_ERR;
        String msg=flag?"添加成功":"添加失败";
        return new Result(code,flag,msg);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        boolean flag = userService.update(user);
        Integer code=flag?Code.UPDATE_OK:Code.UPDATE_ERR;
        String msg=flag?"更新成功":"更新失败";
        return new Result(code,flag,msg);
    }

    @DeleteMapping("/{id}")
    private Result deleteById(@PathVariable int id){
//        if(id<0){
//            throw new BusinessException(Code.BUSINESS_ERR, "id不能小于0,别闹~");
//        }
//        try {
//            int i=1/0;
//        } catch (Exception e) {
//            throw new SystemException(Code.SYSTEM_ERR,"0不能做除数,别闹~");
//        }
        boolean flag = userService.deleteById(id);
        Integer code=flag?Code.DELETE_OK:Code.DELETE_ERR;
        String msg=flag?"删除成功":"删除失败，查无此人";
        return new Result(code,flag,msg);
    }

//    @GetMapping
//    private Result selectByPage(@RequestBody int currentPage,@RequestBody int pageSize){
//        PageBean<User> userPageBean = userService.selectByPage(currentPage, pageSize);
//
//        Integer code=userPageBean!=null?Code.SELECT_OK:Code.SELECT_ERR;
//        return new Result(code,userPageBean);
//    }

    @GetMapping("/{currentPage}&{pageSize}")
    private Result selectByPage(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize){
        PageBean<User> userPageBean = userService.selectByPage( currentPage, pageSize);
        Integer code=userPageBean!=null?Code.SELECT_OK:Code.SELECT_ERR;
        return new Result(code,userPageBean);
    }
}













