//package com.springboot.service.impl;
//
//import com.springboot.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * Created by xiaohong on 2017/11/23.
// */
//@Service
//public class RedisServiceImpl implements RedisService{
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//
//    @Resource(name = "stringRedisTemplate")
//    private ValueOperations<String, String> valOpsStr;
//
//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//
//    @Resource(name = "redisTemplate")
//    private ValueOperations<Object, Object> valOpsObj;
//
//    /**
//     * 根据指定key获取String
//     * @param key
//     * @return
//     */
//    @Override
//    public String getStr(String key){
//        return valOpsStr.get(key);
//    }
//
//    /**
//     * 设置Str缓存
//     * @param key
//     * @param val
//     */
//    @Override
//    public void setStr(String key, String val){
//        valOpsStr.set(key,val);
//    }
//
//    /**
//     * 删除指定key
//     * @param key
//     */
//    @Override
//    public void del(String key){
//        stringRedisTemplate.delete(key);
//    }
//
//    /**
//     * 根据指定o获取Object
//     * @param o
//     * @return
//     */
//    @Override
//    public Object getObj(Object o){
//        return valOpsObj.get(o);
//    }
//
//    /**
//     * 设置obj缓存
//     * @param o1
//     * @param o2
//     */
//    @Override
//    public void setObj(Object o1, Object o2){
//        valOpsObj.set(o1, o2);
//    }
//
//    /**
//     * 删除Obj缓存
//     * @param o
//     */
//    @Override
//    public void delObj(Object o){
//        redisTemplate.delete(o);
//    }
//
//}
