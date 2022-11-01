package com.chao.config;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Servlet 容器初始化配置
 * -----------------------------简化版直接继承 AbstractAnnotationConfigDispatcherServletInitializer
 * @author Eliot
 */
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    /**
     * 加载springMVC容器配置
     * @return 返回atx容器
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext atx=new AnnotationConfigWebApplicationContext();
        atx.register(SpringMvcConfig.class);
        return atx;
    }

    /**
     * 设置那些请求归属springMVC处理
     * @return 所有请求
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 加载spring容器配置
     * @return 返回atx容器
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext atx=new AnnotationConfigWebApplicationContext();
        atx.register(SpringConfig.class);
        return atx;
    }

    /**
     * 处理请求中文乱码问题
     * @return 返回filter数组
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
