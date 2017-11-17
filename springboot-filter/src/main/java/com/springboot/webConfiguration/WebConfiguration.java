package com.springboot.webConfiguration;

import com.springboot.webConfiguration.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;

/**
 * Created by xiaohong on 2017/11/15.
 */

/**
 * 两种方式，灵活性FilterRegistrationBean
 */
@Configuration
public class WebConfiguration {
//    /*
//    一种
//     */
//    @Bean("myFilter")
//    public Filter createFilter() {
//        return new MyFilter();
//    }
//
//    /*
//    二种
//     */
//    @Bean
//    public FilterRegistrationBean MyFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new MyFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MyFilter1");
//        registration.setOrder(1);
//        return registration;
//    }
}
