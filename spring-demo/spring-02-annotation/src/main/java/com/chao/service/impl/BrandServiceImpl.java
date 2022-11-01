package com.chao.service.impl;

import com.chao.config.MybatisConfig;
import com.chao.config.SpringConfig;
import com.chao.dao.BrandDao;
import com.chao.pojo.Brand;
import com.chao.service.BrandService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public void selectAll(){
        System.out.println(brandDao.selectAll());
    }

    @Override
    public void selectById(int id){
        System.out.println(brandDao.selectById(id));
    }

    @Override
    public boolean checkUrlPassword(String url, String password){
        return "1234".equals(password);
    }
}
