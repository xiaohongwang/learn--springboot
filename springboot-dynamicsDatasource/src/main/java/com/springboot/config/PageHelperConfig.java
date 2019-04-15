package com.springboot.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * @Description: pagehelper mybatis分页插件
 * @Author: wangxh
 * @Date: 2019-04-11 16:19
 */
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");//多余的数据是否作为新的页
        properties.setProperty("rowBoundsWithCount","true");//读取总数
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
