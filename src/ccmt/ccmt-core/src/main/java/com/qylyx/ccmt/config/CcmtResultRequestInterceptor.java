package com.qylyx.ccmt.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qylyx.remex.iecup.mop.RemexResultRequestHandle;

/**
 * 处理spring mvc请求结果，将其转换为统一输出格式ResultRequest
 * 
 * @author Qiaoxin.Hong
 *
 */
@Aspect
@Component
public class CcmtResultRequestInterceptor {
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || execution(* com.qylyx.ccmt..*.*(..))")
	private void method(){}
	
	protected RemexResultRequestHandle resultRequestHandle = new RemexResultRequestHandle();
	
	@Around("method()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		return resultRequestHandle.handle(point);
	}
}
