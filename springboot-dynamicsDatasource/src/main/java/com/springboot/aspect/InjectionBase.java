package com.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: wangxh
 * @Date: 2019-03-11 16:15
 */
public class InjectionBase {
    /**
     * 获取拦截实体
     *
     * @param pjp
     * @return Object
     */
    protected Object getTarget(ProceedingJoinPoint pjp) {
        return pjp.getTarget();
    }

    /**
     * 获取拦截方法名称
     *
     * @param pjp
     * @return String
     */
    protected String getHookName(ProceedingJoinPoint pjp) {
        return pjp.getSignature().getName();
    }

    /**
     * 获取拦截方法参数
     *
     * @param pjp
     * @return Object[]
     */
    protected Object[] getHookArgs(ProceedingJoinPoint pjp) {
        return pjp.getArgs();
    }

    /**
     * 获取拦截的参数类型
     *
     * @param pjp
     * @return Class<?>[]
     */
    protected Class<?>[] getHookArgType(ProceedingJoinPoint pjp) {
        return getHookMethod(pjp).getParameterTypes();
    }

    /**
     * 获得方法返回类型
     *
     * @param pjp
     * @return Class<?>[]
     * @throws Exception
     */
    protected Class<?> getHookReturnType(ProceedingJoinPoint pjp) {
        return getHookMethod(pjp).getReturnType();
    }

    /**
     * 获取被拦截方法
     *
     * @param pjp
     * @return Method 2016年4月25日-下午1:50:19
     */
    protected Method getHookMethod(ProceedingJoinPoint pjp) {
        Method method = null;
//        try {
//            method = getTarget(pjp).getClass().getMethod(getHookName(pjp), getHookArgType(pjp));
//        } catch (NoSuchMethodException | SecurityException e) {
//            e.printStackTrace();
//        }

        method = ((MethodSignature) pjp.getSignature()).getMethod();
        return method;
    }

    /**
     * 获取方法注解
     *
     * @param pjp
     * @param annotationClass
     * @return T
     */
    protected <T extends Annotation> T getHookAnno(ProceedingJoinPoint pjp, Class<T> annotationClass) {
        return getHookMethod(pjp).getAnnotation(annotationClass);
    }

    /**
     * 获取方法注解集合
     *
     * @param pjp
     * @return Annotation[]
     */
    protected <T extends Annotation> Annotation[] getHookAnnos(ProceedingJoinPoint pjp) {
        return getHookMethod(pjp).getAnnotations();
    }
}
