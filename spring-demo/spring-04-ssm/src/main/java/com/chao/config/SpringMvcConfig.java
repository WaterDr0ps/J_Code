package com.chao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Eliot
 */
@Configuration
@ComponentScan({"com.chao.config","com.chao.controller"})
@EnableWebMvc
public class SpringMvcConfig {
}
