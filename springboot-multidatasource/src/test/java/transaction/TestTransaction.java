package transaction;

import com.springboot.SpringBootStarter;
import com.springboot.mapper.ClazzMapper;
import com.springboot.mapper.SysUserMapper;
import com.springboot.model.Clazz;
import com.springboot.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarter.class)
public class TestTransaction {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private ClazzMapper clazzMapper;

    @Test
    @Transactional
    public void test(){
        SysUser sysUser = new SysUser();
        sysUser.setId(9);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("21");
       sysUserMapper.insert(sysUser);

       Clazz clazz = new Clazz();
       clazz.setId(1);
       clazz.setClazzName("外语班");
       clazz.setClazzAge("6");
       clazzMapper.insert(clazz);
    }
}
