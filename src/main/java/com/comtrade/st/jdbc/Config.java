/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.jdbc;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author radoo
 */
@Configuration
public class Config {
	/**
	 * <p>
	 * init ds     
	 * </p>
	 * @param  param  param_desc   
	 * @return db   
 Changes:
	 * @author Rado 11.8.2017  created  
	 */
	@Bean("dataSource")
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("shema.sql")
			.addScript("test-data.sql")
			.build();
		return db;
	}//end datasource		

	/**
	 * <p>
	 * desc     
	 * </p>
	 * @param  param  param_desc   
	 * @return JdbcContactDao   
	 * Changes:
	 * @author author_name date  created  
	 */
	@Bean("contactDao")
	public JdbcContactDao contactDao() {
		return new JdbcContactDao();
	}//end contactDao

	/**
	 * <p>
	 * jdbc template with ds     
	 * </p>
	 * @param  param  param_desc   
	 * @return JdbcTemplate   
	 * Changes:
	 * @author author_name date  created  
	 */
	@Bean
	public  JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}//end jdbcTemplate
}//end Config
