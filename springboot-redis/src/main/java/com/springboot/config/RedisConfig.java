//package com.springboot.config;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//
///**
// * Created by xiaohong on 2017/11/23.
// */
//@Configuration
//public class RedisConfig{
//    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//
//    @Bean("stringRedisTemplate")
//   public  StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory){
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(factory);
//        return stringRedisTemplate;
//    }
//
//    @Value("${redis.host}")
//    private String hostName;
//
//    @Value("${redis.port}")
//    private int port;
//
//    @Value("${redis.maxIdle}")
//    private int maxIdle;
//
//    @Value("${redis.minIdle}")
//    private int minIdle;
//
//    @Value("${redis.maxTotal}")
//    private int maxTotal;
//
//    /**
//     * 简单连接redis
//     */
////    @Bean
////    public RedisConnectionFactory getFactory(){
////        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
////        jedisFactory.setHostName(hostName);
////        jedisFactory.setPort(Integer.valueOf(port));
////        jedisFactory.setUsePool(false);
////        return jedisFactory;
////    }
//}
