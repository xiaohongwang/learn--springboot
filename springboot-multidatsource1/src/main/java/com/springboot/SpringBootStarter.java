package com.springboot;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.config.MapperScannerBeanDefinitionParser;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaohong on 2017/11/13.
 */
/*
    spring-boot-starter-jdbc默认只能设定一个数据源的。
    所以，我们需要修改一下SpringBoot的启动项，排除掉默认的DataSource的自动配置。
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,MybatisAutoConfiguration.class})
@RestController
public class SpringBootStarter {

    public static void main(String[] args){
        SpringApplication.run(SpringBootStarter.class,args);
    }

    @RequestMapping("/test")
    public String test(){
        return "Hello Spring Boot!!";
    }
}
