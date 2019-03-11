### Spring AOP  面向切面编程 配置注意事项
  
    (1)、注解方式  
        1、需要开启注解支持
            xml方式配置支持 
```
<!--启用@AsjectJ支持注解方式配置切面 默认是用JDK代理，proxy-target-class 使用CGLIB代理-->
<aop:aspectj-autoproxy proxy-target-class="true"/>
```
         SpringBoot配置支持
```
spring:
  aop:
    auto: true  #@AsjectJ支持注解方式配置切面
    proxy-target-class: true #使用CGLIB代理
```
        2、切面配置  @Aspect  完成特定功能的类就是一个切面，在这个类中可以设置方法执行之前、之后以及执行前后要执行的具体的操作
```
@Component
@Aspect //切面
public class HandlerDataSourceAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerDataSourceAop.class);
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
                    +";methodName: " + method.getName()+";dataSourceKey: " + dataSource =="" ? "默认数据源" : dataSource);
        }
}
```
        3、连接点 被代理对象中某个特定的方法，表明在执行该方法时，程序的顺序行会被打乱，转而去执行额外的操作
        4、切入点配置  匹配连接点的断言  execution/@annotation常用
```
// SysUserServiceImpl 任意方法
 @Pointcut("execution(* com.springboot.service.impl.SysUserServiceImpl.*(..))")
    public void pointcut(){}
```
   |方式|例子|说明|
   |:----:|:----:|:----:|
   |execution 方法描述匹配|"execution(* com.springboot.springcode.service..*.*(..))"|第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示方法的任意参数个数|
   |within /target目标类匹配|"within(com.springboot.service..*)"|service包及其子包下的所有类|
   |within / @target 目标类上的注解|"@within(com.springboot.annotations.DynamicSwitchDataSource)"|带有@DynamicSwitchDataSource标注的所有类的任意方法|
   |this 当前AOP代理对象类型匹配|this(com.springboot.service.SysUserService)|实现了SysUserService接口的所有类,如果SysUserService不是接口,限定SysUserService单个类|
   |@annotation 目标方法上的注解|@annotation(com.springboot.annotations.DynamicSwitchDataSource|带有@DynamicSwitchDataSource标注的所有方法|
   |@args /arg 参数||||
    
        5、通知
        通知中的参数有多个时，应将JoinPoint或ProceedingJoinPoint参数放在 第一位
```
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
                +";methodName: " + method.getName()+";dataSourceKey: " + dataSource =="" ? "默认数据源" : dataSource);
    }
```
   |通知|注解|设置|
   |:----:|:----:|:----:|
   |前置|@Before|@Before("pointcut()")|
   |环绕|@Around||
   |后置|@AfterReturning||
   |异常|@AfterThrowing||
   |最终|@After||||

    (2)、xml方式
    暂不叙述
   
### 通知的执行规则 
```
1.当异常通知执行时，后置通知将不会执行。异常通知和后置通知是互斥的。
2.最终通知无论如何都会被执行。
3.当目标方法执行时出现异常时，环绕通知的后半部分将不会被执行。
4.当环绕通知遇到后置通知时，如果后置通知想得到返回值，那么环绕通知必须添加return 将返回值返回
5.当多个环绕通知同时执行时，其执行顺序是嵌套结构
joinPoint.proceed() 作用有两个 
1.如果有下一个通知，就执行下一个通知，
2.如果没有下一个通知 则执行目标方法。
```

### 通知中操作对象  JoinPoint / ProceedingJoinPoint  获取参数 获取方法注解 
```
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
```

















