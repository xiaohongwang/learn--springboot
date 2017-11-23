package springboot.redis;

import com.springboot.JedisApplication;
import com.springboot.config.ClusterTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisApplication.class)
public class ClusterTest {
    @Resource
    private ClusterTemplate clusterTemplate;

    @Test
    public void test(){
        clusterTemplate.set("name", "xiaoshuang");
    }

}
