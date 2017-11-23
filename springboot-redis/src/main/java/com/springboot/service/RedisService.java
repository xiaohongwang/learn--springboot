package com.springboot.service;

/**
 * Created by xiaohong on 2017/11/23.
 */
public interface RedisService {
    String getStr(String key);

    void setStr(String key, String val);

    void del(String key);

    Object getObj(Object o);

    void setObj(Object o1, Object o2);

    void delObj(Object o);
}
