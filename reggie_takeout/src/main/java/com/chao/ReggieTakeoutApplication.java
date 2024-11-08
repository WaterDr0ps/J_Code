package com.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching
public class ReggieTakeoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieTakeoutApplication.class, args);
    }

}
