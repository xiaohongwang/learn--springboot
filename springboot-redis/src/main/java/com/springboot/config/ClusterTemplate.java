package com.springboot.config;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by xiaohong on 2017/11/23.
 */
@Component
public class ClusterTemplate {

    @Resource
    private JedisCluster jedisCluster;

    @Resource
    private ClusterPro clusterPro;

    public boolean set(String key, String value){
        jedisCluster.set(key, value);
        return true;
    }

}
