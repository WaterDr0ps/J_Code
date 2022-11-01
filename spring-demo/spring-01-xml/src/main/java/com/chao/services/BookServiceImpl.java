package com.chao.services;

import com.chao.dao.BookDao;
import com.chao.dao.UserDao;

public class BookServiceImpl implements BookService {
    /**
     * setter引用类型注入
     */
    private BookDao bookDao;
    private UserDao userDao;
    @Override
    public void say() {
        System.out.println("service say...");
        bookDao.say();
        userDao.say();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
