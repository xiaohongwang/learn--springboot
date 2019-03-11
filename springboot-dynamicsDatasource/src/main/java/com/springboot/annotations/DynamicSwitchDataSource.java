package com.springboot.annotations;

import java.lang.annotation.*;

/**
 * @description: 创建拦截设置数据源
 * 在代码中可通过 DatabaseContextHolder.setDataSourceType("datasource1");
 * 在代码中频繁的调用此方式可以解决问题，但绝不是一个好的解决方案
 * 在业务处理中穿插 技术性代码 ，业务代码应该更多的关注业务处理
 *
 * 采用注解的方式, 可以解决问题，大大优化代码，使代码更简洁
 * 也有利于开发人员开发工作
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDataSource {
//    数据源key
    String dataSource() default "";
}
