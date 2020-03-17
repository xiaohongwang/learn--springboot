package com.springboot.aspect;

import com.springboot.annotations.LogAnno;
import com.springboot.utils.Common;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
* @Title:
* @Description: 切面：拦截注解LogAnno,根据需要记录系统操作日志信息
* @author: wangxiaohong
* @param:
* @return
* @date: 19:30 2020-03-13
* @version v1.0
*/
@Aspect
@Component
public class LogAopAspect extends InjectionBase{

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAopAspect.class);

	@Pointcut("@annotation(com.springboot.annotations.LogAnno)")
	public void pointcut(){}


	@Around("pointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// 获取方法注解
		LogAnno logAnno = getHookAnno(pjp, LogAnno.class);
		/**获取注解属性**/
		// 操作模块
		String operateModule = logAnno.operateModule();

		// 操作内容
		String operateContent = logAnno.operateContent();

		// 操作方法
		String operateMethod = logAnno.operateMethod();

		LOGGER.info("====操作模块==={}, 操作内容==={}, 操作方法:{}",
				operateModule, operateContent, operateMethod);
		Object result = null;
		try {
			// 实体
	        Object target = getTarget(pjp);
			// 方法名
			String methodName = getHookName(pjp);

			ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
			if (attributes != null) {
				HttpServletRequest request = attributes.getRequest();
				// 请求地址
				String url = request.getRequestURL().toString();
				// 请求的ip地址
				String ipAddress = Common.getClientIp(request);
				LOGGER.info("===客户端请求ip地址===={}", ipAddress);
			}
			// 方法和请求参数设置
			String className = target.getClass().getName();
			// 请求参数
			Object[] args = getHookArgs(pjp);
			// 执行业务逻辑
			result = pjp.proceed();
		} catch (Exception e) {
			LOGGER.info("AOP 操作日志异常", e);
		} finally {
//			TODO
			LOGGER.info("====请求结果信息==={}", result);
		}
		return result;
	}
}
