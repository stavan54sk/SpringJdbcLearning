package com.testpackage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import com.testpackage.dao.StudentDao;
import com.testpackage.dao.StudentDaoImpl;

@Configuration
public class ConfigurationClass {

	@Bean
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/classicmodels");
		datasource.setUsername("root");
		datasource.setPassword("root1234");
		return datasource;
	}

	@Bean
	public StudentDao studentDao() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.setDataSource(datasource());
		studentDaoImpl.setLobHandler(defaultLobHandler());
		return studentDaoImpl;
	}

	@Bean
	public DefaultLobHandler defaultLobHandler() {
		return new DefaultLobHandler();
	}

}
