package com.qylyx.ccmt.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.qylyx.july.salog.pop.SalogHandle;


@Aspect
@Component
public class CcmtSalogInterceptor {
	
	@Autowired
	private SalogHandle salogHandle;
	
	@Pointcut("@annotation(com.qylyx.july.salog.annotation.Salog)")
	private void salogMethod() {}
	
	@Around("salogMethod()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		return salogHandle.handle(point);
	}
	
	@Bean
	public SalogHandle salogHandle() {
		return new SalogHandle();
	}

}
