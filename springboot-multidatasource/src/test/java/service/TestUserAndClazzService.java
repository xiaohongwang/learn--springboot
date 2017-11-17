package service;

import com.springboot.SpringBootStarter;
import com.springboot.service.UserAndClazzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarter.class)
public class TestUserAndClazzService {
    @Resource
    private UserAndClazzService userAndClazzService;

    @Test
    public void test(){
        userAndClazzService.insertValue();
    }
}
