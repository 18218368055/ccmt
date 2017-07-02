package com.qylyx.ccmt.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro的配置类
 * 
 * @author Qiaoxin.Hong
 *
 */
@Configuration
public class ShiroConfig {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		//配置登录的url和登录成功的url
		bean.setLoginUrl("/toLogin");
		bean.setSuccessUrl("/index");
		
		//配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/WEB-INF/layouts/default.jsp", "anon");
		filterChainDefinitionMap.put("/WEB-INF/views/sms/login.jsp", "anon");
		
		filterChainDefinitionMap.put("/toLogin", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		
		filterChainDefinitionMap.put("/**", "authc");
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}
	
	/**
	 * shiro核心安全事务管理器
	 * @param authRealm
	 * @return
	 */
	@Bean
	public SecurityManager securityManager(ShiroRealm shiroRealm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(shiroRealm);
		return manager;
	}
	
	/**
	 * 登录权限登录器
	 * @return
	 */
	@Bean
	public ShiroRealm shiroRealm() {
		ShiroRealm realm = new ShiroRealm();
		return realm;
	}
}
