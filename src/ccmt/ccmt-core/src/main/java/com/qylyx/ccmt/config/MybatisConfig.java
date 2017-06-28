package com.qylyx.ccmt.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置
 * 
 * @author Qiaoxin.Hong
 *
 */
@Configuration
@MapperScan("com.qylyx.ccmt.sms.dao.user")
public class MybatisConfig {
	
	@Autowired
	private MybatisProperties properties;
	
	/**
	 * mybatis SqlSessionFactoryBean
	 * @param dataSource
	 * @return
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(properties.resolveMapperLocations());
		bean.setConfiguration(properties.getConfiguration());
		return bean.getObject();
	}
}
