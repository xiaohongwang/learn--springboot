package com.springboot.test.config;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
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
public class TestSqlSessionFactory {
    @Resource(name = "sqlSessionFactory")
    private DefaultSqlSessionFactory sqlSessionFactory;

    @Test
    public void test(){
        System.out.println(sqlSessionFactory.toString());
    }
}
