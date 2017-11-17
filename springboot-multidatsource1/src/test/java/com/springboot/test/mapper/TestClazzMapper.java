package com.springboot.test.mapper;

import com.springboot.mapper.ClazzMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClazzMapper {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    public void test(){
        System.out.println(clazzMapper.selectByPrimaryKey(1).toString());
    }
}
