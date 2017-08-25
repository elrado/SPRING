/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import com.comtrade.st.jdbc.*;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author radoo
 */
@Configuration
public class Config {

	@Bean("contact")
	public Contact contact(ConversionService conversionService) {
		Contact ct = new Contact();
		//ct.setBirthDate( conversionService.convert("06.05.1977"));
		ct.setFirstName("Rado");
		ct.setLastName("Osredkar");
		return ct;
	}

	@Bean("conversionService")
	public ConversionService conversionService(StringToDateTimeConverter stringToDateTimeConverter, ContactToAnotherContactConverter contactToAnotherContactConverter) {
		DefaultConversionService service = new DefaultConversionService();
		service.addConverter(stringToDateTimeConverter);
		service.addConverter(contactToAnotherContactConverter);
		return service;
	}

	@Bean("stringToDateTimeConverter")
	public StringToDateTimeConverter stringToDateTimeConverter() {
		return new StringToDateTimeConverter();
	}

	@Bean("contactToAnotherContactConverter")
	public ContactToAnotherContactConverter contactToAnotherContactConverter() {
		return new ContactToAnotherContactConverter();
	}

	/**
	 * <p>
	 * init ds
	 * </p>
	 *
	 * @param param param_desc
	 * @return db Changes:
	 * @author Rado 11.8.2017 created
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
	 *
	 * @param param param_desc
	 * @return JdbcContactDao Changes:
	 * @author author_name date created
	 */
	@Bean("contactDao")
	public JdbcContactDao contactDao() {
		return new JdbcContactDao();
	}//end contactDao

	/**
	 * <p>
	 * jdbc template with ds
	 * </p>
	 *
	 * @param param param_desc
	 * @return JdbcTemplate Changes:
	 * @author author_name date created
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}//end jdbcTemplate

	/**
	 * <p>
	 * jdbc template with ds
	 * </p>
	 *
	 * @param param param_desc
	 * @return NamedParameterJdbcTemplate Changes:
	 * @author author_name date created
	 */
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		return namedParameterJdbcTemplate;
	}//end jdbcTemplate
}//end Config
