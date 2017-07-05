package com.qylyx.ccmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.qylyx.ccmt.core.converter.DateConverter;

/**
 * mvc配置
 * 
 * @author Qiaoxin.Hong
 *
 */
@Configuration
public class CcmtWebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		//日期格式转换器
		registry.addConverter(new DateConverter());
		super.addFormatters(registry);
	}
}
