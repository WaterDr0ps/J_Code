package com.chao.config;


import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 说明是配置文件
 */
@Configuration
/**
 * 扫描""包下的所有注解bean
 */
@ComponentScan("com.chao")
/**
 * 指定资源文件,多个配置文件用{" "," "}
 */
@PropertySource("/jdbc.properties")
/**
 * 用于引入其他bean,推荐使用import,不建议扫描,多个配置文件使用{}
 */
@Import({JdbcConfig.class,MybatisConfig.class})
/**
 * 指明有aop需要被识别
 * 启用Aspect J自动代理
 */
@EnableAspectJAutoProxy
/**
 * 启用事务管理
 */
@EnableTransactionManagement
public class SpringConfig {
}
