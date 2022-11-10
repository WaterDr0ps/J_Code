package com.chao.service.impl;

import com.chao.dao.UserDao;
import com.chao.pojo.PageBean;
import com.chao.pojo.User;
import com.chao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eliot
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public boolean add(User user) {
        int flag = userDao.add(user);
        return flag > 0;
    }

    @Override
    public boolean deleteById(int id) {
        int flag = userDao.deleteById(id);
        return flag > 0;
    }

    @Override
    public boolean update(User user) {
        int flag = userDao.update(user);
        return flag > 0;
    }

    @Override
    public PageBean<User> selectByPage(int currentPage, int pageSize) {
        List<User> users = userDao.pageQuery((currentPage - 1) * pageSize, pageSize);
        int count = userDao.selectTotal();
        PageBean<User> user = new PageBean<>();
        user.setRows(users);
        user.setTotalCount(count);
        return user;
    }


}
