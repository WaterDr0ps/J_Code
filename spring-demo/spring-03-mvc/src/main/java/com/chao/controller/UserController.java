package com.chao.controller;

import com.chao.pojo.User;
import com.chao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController  将@Controller和@ResponseBody合二为一
 * RequestMapping  让所有方法的路径一样(restful简化方法路径书写)
 * @author Eliot
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * RequestMapping   说明该方法请求路径,不同方法路径一样请求方法不一样(rest风格)
     * ResponseBody     说明作为一个响应体(字符串)  转json数据是由 HttpMessageConverter接口来实现
     * RequestBody      获取请求体json数据
     * @param user      接收一个User对象 RequestBody表示数据从请求体获取(json)
     * @return          返回响应
     */

    /*
     * PostMapping/DeleteMapping/PutMapping/GetMapping      简化RequestBody
     * 如果请求体需要路径参数,需要在注解上添加路径参数
     */

    @PostMapping
    public User add(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    /**
     * @param id 请求参数为一个时,路径通过{参数名}来识别,参数使用@PathVariable注解
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        System.out.println("id="+id+",deleted...");
        return "{'user':'delete'}";
    }

    @PutMapping
    public String update(@RequestBody User user){
        System.out.println(user);
        return "{'user':'update'}";
    }

    @GetMapping
    public List<User> selectAll(){
        List<User> users = userService.selectAll();
        return users;
    }

}
