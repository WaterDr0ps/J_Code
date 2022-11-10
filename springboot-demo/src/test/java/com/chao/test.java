package com.chao;

import com.chao.dao.UserDao;
import com.chao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Eliot
 */
@SpringBootTest
public class test {
    @Autowired
    private UserDao userDao;

    @Test
    public void userTest(){
        List<User> users = userDao.selectAll();
        System.out.println(users);
    }
}
