package com.qylyx.ccmt.config;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.qylyx.july.salog.extract.SalogExtractInfo;
import com.qylyx.remex.base.rconst.result.RemexResultConst;
import com.qylyx.remex.base.web.exception.RemexRequestException;
import com.qylyx.remex.framework.base.entity.result.ResultRequest;
import com.qylyx.remex.iecup.exception.RemexIecupException;
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
//	private final static Logger cerlogger = LoggerFactory.getLogger(CcmtExceptionResolver.class);
//
//	@Override
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		Logger logger = LoggerFactory.getLogger(handler.getClass());
//		
//		//请求页面，还是请求数据
//		boolean isReqView = true;
//		//日志前缀信息
//		String logPrefix = "操作异常！";
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			logPrefix = SalogExtractInfo.getLogPrefix(handlerMethod.getBeanType(), handlerMethod.getMethod());
//			logPrefix += "，操作异常！ -";
//			
//			//暂时只判断方法上是否有ResponseBody注解来判断是请求页面还是数据
//			isReqView = !handlerMethod.getBeanType().isAnnotationPresent(ResponseBody.class);
//		}
//		
//		String resultRequest = null;
//		if (ex.getClass().equals(RemexIecupException.class)) {
//			RemexRequestException remexRequestException = (RemexRequestException) ex;
//			logger.error(logPrefix + remexRequestException.getLog(), remexRequestException);
//			resultRequest = handleResultRequest(remexRequestException.getCode(), remexRequestException.getShowMsg());
//		} else {
//			logger.error(logPrefix, ex);
//			resultRequest = handleResultRequest(RemexResultConst.CODE_FAIL, RemexResultConst.MSG_FAIL);
//		}
//		
//		//请求页面，直接返回错误页面
//		if (isReqView) {
//			String errorView = handleErrorView(request, response, handler, ex);
//			return new ModelAndView(errorView);
//		} else {  //请求数据，以统一数据格式返回错误信息
//			try {
//				OutputStream out = response.getOutputStream();
//				response.setContentType("application/json;charset=UTF-8");
//				PrintWriter pw = new PrintWriter(out);
//				pw.write(JSONObject.toJSONString(resultRequest));
//				pw.flush();
//				out.close();
//			} catch (IOException e) {
//				cerlogger.error("统一异常处理时异常！", e);
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 请求数据异常时，返回给前端的数据，默认使用ResultRequest的json格式，子类可重写来返回新的数据格式
//	 * @see com.qylyx.remex.framework.base.entity.result.ResultRequest
//	 * @param code 异常代码
//	 * @param showMsg 展示的异常信息
//	 * @return
//	 */
//	protected String handleResultRequest(String code, String showMsg) {
//		return JSONObject.toJSONString(new ResultRequest(RemexResultConst.CODE_FAIL, RemexResultConst.MSG_FAIL));
//	}
//	
//	/**
//	 * 错误视图界面
//	 * @return
//	 */
//	protected String handleErrorView(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		return "error/500";
//	}
}
