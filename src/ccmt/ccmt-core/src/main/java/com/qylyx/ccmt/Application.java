package com.qylyx.ccmt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.qylyx.ccmt.core.context.ApplicationContextUtils;

/**
 * 启动类
 * 
 * @author Qiaoxin.Hong
 *
 */
@SpringBootApplication
public class Application {
	/**
	 * 启动函数
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(Application.class).web(true).run(args);
		//将ApplicationContext注入到一个容器中，用于后续的一些需要ApplicationContext的操作
		ApplicationContextUtils.setApplicationContext(context);
	}
}
