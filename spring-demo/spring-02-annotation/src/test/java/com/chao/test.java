package com.chao;

import com.chao.config.SpringConfig;
import com.chao.dao.BankUserDao;
import com.chao.service.BankUserService;
import com.chao.service.BrandService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author Eliot
 */

/**
 * spring指定junit的类运行器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载spring配置容器
 */
@ContextConfiguration(classes = SpringConfig.class)
public class test {
    @Autowired
    private BrandService brandService;
    @Autowired
    private BankUserService bankUserService;

    @Test
    public void selectAllTest(){
        brandService.selectAll();
    }

    @Test
    public void checkUrlPasswordTest(){
        boolean b = brandService.checkUrlPassword("baidu.com", "1234 ");
        System.out.println(b);
    }

    @Test
    public void bankTest(){
        bankUserService.transfer("张三","李四",100);
    }

}





















