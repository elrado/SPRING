/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.hibernate;

import com.comtrade.st.jdbc.*;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author radoo
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.comtrade.st.hibernate")
public class Config {

	/**
	 * <p>
	 * init ds
	 * </p>
	 *
	 * @param param param_desc
	 * @return db Changes:
	 * @author Rado 11.8.2017 created
	 */
	//@Bean("EmbededDataSourcedataSource")
	public DataSource EmbededDataSourcedataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("shema.sql")
			.addScript("test-data.sql")
			.build();
		return db;
	}//end datasource		

	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:d:/temp/h2test;DB_CLOSE_ON_EXIT=FALSE");
		return dataSource;
	}//end datasource		

	@Bean("transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}// end transactionManager

	/**
	 * <p>
	 * SessionFactory bean
	 * </p>
	 *
	 * @param param param_desc
	 * @return SessionFactory Changes:
	 * @author author_name date created
	 */
	@Bean("sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource, Properties hibernateProperties) throws IOException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.comtrade.st");
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.afterPropertiesSet();
		return sessionFactory.getObject();
	}//end sessionFactory

	@Bean("hibernateProperties")
	Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("connection.driver_class", "org.h2.Driver");
		properties.setProperty("connection.url", "jdbc:h2:file:d:/temp/h2test;DB_CLOSE_ON_EXIT=FALSE");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.max_fetch_depth", "3");
		properties.setProperty("hibernate.jdbc.fetch_size", "5");
		properties.setProperty("hibernate.jdbc.batch_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		//properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
		return properties;
	}

}//end Config
