package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaohong on 2017/11/23.
 */
@Configuration
@Import(ClusterPro.class)
public class JedisClusterConfig {

    @Resource
    private ClusterPro clusterPro;

    @Bean
    public JedisCluster getCluster(){
        String[] arr = clusterPro.getNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        for (String ipPort : arr){
            System.out.println(ipPort);
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes, clusterPro.getCommandTimeout());
    }


}
