package com.springboot.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperScanner {
    @Resource
    private MapperScannerConfigurer mapperScannerConfigurer;

    @Test
    public void test(){
        System.out.println(mapperScannerConfigurer.toString());
    }

    @Resource
    private MapperScannerConfigurer mapperScannerConfigurer2;

    @Test
    public void test2(){
        System.out.println(mapperScannerConfigurer2.toString());
    }
}
