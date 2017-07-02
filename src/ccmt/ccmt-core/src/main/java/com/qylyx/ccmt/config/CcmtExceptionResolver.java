package com.qylyx.ccmt.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.qylyx.remex.iecup.exception.RemexIecupException;

/**
 * （暂时）未实现完的方案，controller统一异常处理类
 * 
 * @author Qiaoxin.Hong
 *
 */
@Component
public class CcmtExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Logger logger = LoggerFactory.getLogger(handler.getClass());
		if (ex.getClass().equals(RemexIecupException.class)) {
			RemexIecupException remexIecupException = (RemexIecupException) ex;
			logger.error(remexIecupException.getLog(), remexIecupException);
		} else {
			logger.error("未知异常！", ex);
		}
		return new ModelAndView("error/500");
	}

}
