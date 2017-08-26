/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 *
 * @author radoo
 */
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	private static final String DEFAULT_DATE_PATTERN = "dd.MM.yyyy";
	private DateTimeFormatter dateFormat;
	private String datePattern = DEFAULT_DATE_PATTERN;
	private Set<Formatter<?>> formatters = new HashSet<Formatter<?>>();

	public String getDatePattern() {
		return datePattern;
	}

	@Autowired(required = false)
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@PostConstruct
	public void init() {
		this.dateFormat = DateTimeFormat.forPattern(datePattern);
		this.formatters.add(this.getDateTimeFormatter());
		this.setFormatters(formatters);
	}

	public Formatter<DateTime> getDateTimeFormatter() {
		return new Formatter<DateTime>() {
			@Override
			public String print(DateTime t, Locale locale) {
				System.out.println("Parsing dateTIme: " + t);
				return dateFormat.print(t);
			}

			@Override
			public DateTime parse(String string, Locale locale) throws ParseException {
				System.out.println("Parsing dateString:" + string);
				return dateFormat.parseDateTime(string);
			}
		};
	}

}//end ApplicationConversionServiceFactoryBean
