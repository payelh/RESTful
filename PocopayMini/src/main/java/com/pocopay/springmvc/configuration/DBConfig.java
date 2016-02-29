package com.pocopay.springmvc.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


@Configuration
@Import(PropertyPlaceholderConfig.class)
public class DBConfig {
	static final Logger logger = LoggerFactory.getLogger(DBConfig.class);
	
	@Value("${jdbc.driverClassName}")
	private String driverName;
	
	@Value("${jdbc.url}")
	private String dbUrl;
	
	@Value("${jdbc.username}")
	private String userName;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		logger.info("----------------------------------> dataSourceInitializer");
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("/dataInit.sql"));
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource());
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;		        
	}
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		logger.info("----------------------------------> dataSource()");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
}