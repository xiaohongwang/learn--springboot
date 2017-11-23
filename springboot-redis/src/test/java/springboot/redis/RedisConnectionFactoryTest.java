package springboot.redis;

import com.springboot.JedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisApplication.class)
public class RedisConnectionFactoryTest {
    @Resource
    RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test(){

        System.out.println( ( (JedisConnectionFactory)redisConnectionFactory).getHostName());
    }

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        stringRedisTemplate.opsForValue().set("name", "xiaoxiao");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
        //stringRedisTemplate.delete("name");
    }
}
