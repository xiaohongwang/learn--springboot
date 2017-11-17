package com.springboot.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.channels.spi.SelectorProvider;

/**
 * Created by xiaohong on 2017/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        userMapper.findByUserName("小红");
    }
}
