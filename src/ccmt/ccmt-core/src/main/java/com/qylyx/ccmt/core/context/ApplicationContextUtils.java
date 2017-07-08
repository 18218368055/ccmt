package com.qylyx.ccmt.core.context;

import org.springframework.context.ApplicationContext;

/**
 * 在spring boot启动后，将ApplicationContext注入到此容器，用于后续的一些需要ApplicationContext的操作
 * 
 * @author Qiaoxin.Hong
 *
 */
public class ApplicationContextUtils {
	/**
	 * ApplicationContext
	 */
	private static ApplicationContext context;
	
	/**
	 * 设置ApplicationContext
	 * @param context
	 */
	public static void setApplicationContext(ApplicationContext context) {
		ApplicationContextUtils.context = context;
	}
	
	/**
	 * 获取ApplicationContext
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return context;
	}
}
