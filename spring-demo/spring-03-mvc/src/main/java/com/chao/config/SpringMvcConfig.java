package com.chao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Eliot
 */

@Configuration
@ComponentScan({"com.chao.controller","com.chao.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
