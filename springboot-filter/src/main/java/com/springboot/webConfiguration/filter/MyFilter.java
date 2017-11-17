package com.springboot.webConfiguration.filter;

import groovy.lang.Singleton;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xiaohong on 2017/11/15.
 */
/*
三种
 */
@WebFilter(urlPatterns = "/*",filterName="filter",
        initParams={
                @WebInitParam(name="encoding",value="UTF-8"),
                @WebInitParam(name = "forceEncoding", value = "true")
        })
@Component
@Singleton
public class MyFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("FilterName:" + filterConfig.getFilterName());

    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) srequest;
        System.out.println("this is MyFilter,url :"+request.getRequestURI());
        //放行资源
        filterChain.doFilter(srequest, sresponse);
    }
}
