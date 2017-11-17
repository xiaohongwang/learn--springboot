package com.springboot.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataSource {
    @Resource
    private DataSource dataSource1;
    @Test
    public void test(){
        System.out.println(dataSource1.toString());
    }

    @Resource
    private DataSource dataSource2;
    @Test
    public void test2(){
        System.out.println(dataSource2.toString());
    }
}
