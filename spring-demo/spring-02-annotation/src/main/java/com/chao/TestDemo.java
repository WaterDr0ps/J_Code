package com.chao;

import com.chao.config.SpringConfig;
import com.chao.service.impl.BrandServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {
    public static void main(String[] args) {
        //通过xml方式初始化容器
        //ApplicationContext atx=new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过纯注解方式初始化容器
        ApplicationContext atx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BrandServiceImpl brandService = atx.getBean(BrandServiceImpl.class);
        brandService.selectById(66);
    }
}
