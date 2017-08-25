/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import javax.annotation.PostConstruct;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author radoo
 */
public class StringToDateTimeConverter implements Converter<String, DateTime> {

	private static final String DEFAULT_DATE_PATTERN = "dd.MM.yyyy";
	private DateTimeFormatter dateFormat;
	private String datePattern = DEFAULT_DATE_PATTERN;

	public DateTimeFormatter getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateTimeFormatter dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDatePattern() {
		return datePattern;
	}

	@Autowired(required = false)
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@PostConstruct
	public void init() {
		dateFormat = DateTimeFormat.forPattern(datePattern);
	}

	@Override
	public DateTime convert(String dateString) {
		return dateFormat.parseDateTime(dateString);
	}

}//end StringToDateTimeConverter
