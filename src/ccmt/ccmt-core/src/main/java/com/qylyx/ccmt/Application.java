package com.qylyx.ccmt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
