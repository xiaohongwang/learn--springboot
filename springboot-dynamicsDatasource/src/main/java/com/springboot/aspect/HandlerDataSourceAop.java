package com.springboot.aspect;

import com.springboot.annotations.DynamicSwitchDataSource;
import com.springboot.config.DatabaseContextHolder;
import com.springboot.model.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description: 注解切面
 * @Author: wangxh
 * @Date: 2019-03-08 15:12
 */
@Component
@Aspect
public class HandlerDataSourceAop extends InjectionBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerDataSourceAop.class);

    @Pointcut("execution(* com.springboot.service.impl.SysUserServiceImpl.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DynamicSwitchDataSource annotation = method.getAnnotation(DynamicSwitchDataSource.class);
        if (annotation == null){
            annotation = joinPoint.getTarget().getClass().getAnnotation(DynamicSwitchDataSource.class);
            if (annotation == null) return;
        }

        String dataSource = annotation.dataSource();
        if (!StringUtils.isEmpty(dataSource)){
            DatabaseContextHolder.setDataSourceType(dataSource);
        }
        LOGGER.info("AOP动态切换数据源，className: " + joinPoint.getTarget().getClass().getName()
                +";methodName: " + method.getName()+";dataSourceKey: " + (dataSource =="" ? "默认数据源" : dataSource));
    }

    @After("pointcut()")
    public void doAfter(){
        LOGGER.info("====最终通知===");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "sysUser")
    public void doAfterReturning(JoinPoint joinPoint, SysUser sysUser){
        LOGGER.info("====后置通知===" + sysUser);
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        try {

            Object target = getTarget(joinPoint);

            LOGGER.info("===调用方法名===" + getHookName(joinPoint));

            LOGGER.info("====请求参数===" + Arrays.toString(getHookArgs(joinPoint)));

            LOGGER.info("====环绕通知开始===");
            Object o = joinPoint.proceed();
            LOGGER.info("====环绕通知结束===");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
//    @AfterThrowing


}
