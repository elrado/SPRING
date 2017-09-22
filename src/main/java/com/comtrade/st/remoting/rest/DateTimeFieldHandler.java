/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.rest;

import java.util.Properties;
import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {

	private static String dateFormatPattern;

	public void setConfiguration(Properties config) throws ValidityException {
		dateFormatPattern = config.getProperty("date-format");
	}

	@Override
	public Object convertUponGet(Object o) {
		DateTime dateTime = (DateTime) o;
		return format(dateTime);
	}

	@Override
	public Object convertUponSet(Object o) {
		String dateTimeString = (String) o;
		return parse(dateTimeString);
	}

	@Override
	public Class getFieldType() {
		return DateTime.class;
	}

	protected static String format(final DateTime dateTime) {
		String dateTimeString = "";
		if (dateTime != null) {
			DateTimeFormatter dateTimeFormatter
				= DateTimeFormat.forPattern(dateFormatPattern);
			dateTimeString = dateTimeFormatter.print(dateTime);
		}
		return dateTimeString;
	}

	protected static DateTime parse(final String dateTimeString) {
		DateTime dateTime = new DateTime();
		if (dateTimeString != null) {
			DateTimeFormatter dateTimeFormatter
				= DateTimeFormat.forPattern(dateFormatPattern);
			dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
		}
		return dateTime;
	}

}//end DateTimeFieldHandler
