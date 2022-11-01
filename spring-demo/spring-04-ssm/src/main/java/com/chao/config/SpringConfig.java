package com.chao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eliot
 */

@Configuration
@ComponentScan({"com.chao.dao","com.chao.service"})
@Import({JdbcConfig.class,MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}
