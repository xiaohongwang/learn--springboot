package service;

import com.springboot.DynamicsDSApplication;
import com.springboot.config.DatabaseContextHolder;
import com.springboot.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicsDSApplication.class)
public class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void test1(){
        DatabaseContextHolder.setDataSourceType("datasource1");

        System.out.println(sysUserService.findUserById(4));

        DatabaseContextHolder.setDataSourceType("datasource2");

        System.out.println(sysUserService.findUserById(1));
    }
}
