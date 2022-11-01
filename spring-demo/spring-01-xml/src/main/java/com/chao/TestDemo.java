package com.chao;

import com.chao.dao.BookDaoImpl;
import com.chao.factory.BookDaoFactoryBean;
import com.chao.services.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class TestDemo {
    public static void main(String[] args) {
        //获取IoC(控制反转)容器
        //加载类路径下的配置文件
        ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        BookDaoImpl bookDao = (BookDaoImpl) atx.getBean("bookDao");
//        bookDao.talk();
//        BookServiceImpl bookService = (BookServiceImpl) atx.getBean("bookService");
//        bookService.say();

        DataSource dataSource= (DataSource) atx.getBean("dataSource");
        System.out.println(dataSource);

    }
}
