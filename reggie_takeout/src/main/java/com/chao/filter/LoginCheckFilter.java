package com.chao.filter;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.chao.common.Result;
import com.chao.utils.ThreadLocalUtils;
import com.sun.prism.impl.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Eliot
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取本次请求URI
        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}",requestURI);

        //不需要处理的路径
        String[] urls=new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/user/login"
        };
        //路径不需处理直接放行
        if(check(urls,requestURI)){
            filterChain.doFilter(request,response);
            return;
        }

        //员工已登录放行
        Long emdId = (Long) request.getSession().getAttribute("employee");
        if(emdId!=null){
            ThreadLocalUtils.setCurrentId(emdId);
            filterChain.doFilter(request,response);
            return;
        }

        //用户已登录放行
        if(request.getSession().getAttribute("user") != null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            ThreadLocalUtils.setCurrentId(userId);

            filterChain.doFilter(request,response);
            return;
        }

        //需要处理，给js响应拦截器返回数据
        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
    }

    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            if(pathMatcher.match(url,requestURI)){
                return true;
            }
        }
        return false;
    }
}
