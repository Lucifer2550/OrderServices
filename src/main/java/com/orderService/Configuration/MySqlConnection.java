package com.orderService.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class MySqlConnection {

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sesFact = new LocalSessionFactoryBean();
		
		sesFact.setDataSource(getDataSource());
		sesFact.setHibernateProperties(getConnection());
		sesFact.setPackagesToScan("com.orderService.Entity");
		
		return sesFact;
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/projectOrder");
		dmds.setUsername("root");
		dmds.setPassword("puppy");
		
		return dmds;
	}
	
	public static Properties getConnection() {
	
		Properties p = new Properties();
		
		p.setProperty("hibernate.show_sql","true");
		p.setProperty("hibernate.hbm2ddl.auto","update");
		
		return p;
	}

}
