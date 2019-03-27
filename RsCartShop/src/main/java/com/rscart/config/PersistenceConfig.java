package com.rscart.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.rscart.repository")
@PropertySource(value="classpath:jdbc.properties")
public class PersistenceConfig {
	@Resource
	private Environment env;
	
	@Bean
	public DataSource createDs(){
		BasicDataSource ds=null;
		
		ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	@Bean
	public JdbcTemplate createJdbcTemplate(){
		return new JdbcTemplate(createDs());
	}
}
