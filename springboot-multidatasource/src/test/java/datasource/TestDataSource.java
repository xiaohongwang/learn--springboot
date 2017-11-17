package datasource;

import com.springboot.SpringBootStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarter.class)
public class TestDataSource {

    @Resource
    private DataSource dataSource;

    @Test
    public void test(){
        System.out.println(dataSource.toString());
    }

    @Resource
    private DataSource dataSource2;

    @Test
    public void test2(){
        System.out.println(dataSource2.toString());
    }
}
