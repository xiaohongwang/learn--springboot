import com.springboot.Test7Application;
import com.springboot.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Test7Application.class)
public class SysUserMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void test(){
        System.out.println(sysUserMapper.selectByPrimaryKey(1));
    }
}
