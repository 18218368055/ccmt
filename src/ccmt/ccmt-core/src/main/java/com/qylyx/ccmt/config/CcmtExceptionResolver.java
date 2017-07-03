package com.qylyx.ccmt.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.qylyx.remex.iecup.mop.RemexExceptionResolver;

/**
 * controller统一异常处理类
 * 
 * @author Qiaoxin.Hong
 *
 */
@Component
public class CcmtExceptionResolver extends RemexExceptionResolver {
	
	@Override
	protected String handleErrorView(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		return "error/500";
	}
}
