package com.chao;

import com.chao.config.SpringConfig;
import com.chao.pojo.User;
import com.chao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Eliot
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class test {
    @Autowired
    private UserService userService;

    @Test
    public void deleteById() {
        boolean flag = userService.deleteById(1);
        System.out.println(flag);
    }

    @Test
    public void selectAll() {
        List<User> users = userService.selectAll();
        System.out.println(users);
    }

    @Test
    public void add() {
        User user=new User("村花",22,'女',"14504963484","穆棱市");
        boolean flag = userService.add(user);
        System.out.println(flag);
    }

}










