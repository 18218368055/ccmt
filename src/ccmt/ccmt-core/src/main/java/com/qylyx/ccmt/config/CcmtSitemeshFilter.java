package com.qylyx.ccmt.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

/**
 * sitemesh过滤器
 * @author Qiaoxin.Hong
 *
 */
@Configuration
public class CcmtSitemeshFilter extends ConfigurableSiteMeshFilter {
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		//不进行渲染
		builder.addExcludedPath("/static/");
		
		//对指定路径进行渲染
		builder.addDecoratorPath("/*", "/WEB-INF/layouts/default.jsp");
	}
}
