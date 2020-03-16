package com.springboot.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title:
* @Description: 日志注解
* @author: wangxiaohong
* @param:
* @return
* @date: 19:25 2020-03-13
* @version v1.0
*/
// 方法注解
@Target(ElementType.METHOD)
// 运行时可见
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnno {

	/**注解参数**/
	// 操作模块
	String operateModule() default "";
	// 操作方法
	String operateMethod() default "";
	// 操作内容
	String operateContent() default "";
	
}