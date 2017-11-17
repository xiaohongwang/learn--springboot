package com.springboot.test.config;

import com.springboot.mybatisConfig.JdbcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbcConfig {
    @Resource
    private JdbcConfig jdbcConfig;

    @Test
    public void test(){
        System.out.println(jdbcConfig.toString());
    }
}
