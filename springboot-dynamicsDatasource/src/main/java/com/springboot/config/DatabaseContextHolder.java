package com.springboot.config;

/**
 * Created by xiaohong on 2017/11/20.
 * 保存一个线程安全的DatabaseType容器
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(String db){
        contextHolder.set(db);
    }

    public static String getDataSourceType(){
        return contextHolder.get();
    }

    public static void removeDataSourceType(){
        contextHolder.remove();
    }
}
