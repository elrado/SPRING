/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.jdbc;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class Run {
	private static final Logger logger = Logger.getLogger(Run.class);
	public static void main(String[] args) {
		ApplicationContext ctx = 
			new AnnotationConfigApplicationContext(Config.class);		
		JdbcContactDao contactDao = (JdbcContactDao)ctx.getBean("contactDao");
		String last_name = contactDao.findLastNameById(1L);
		System.out.println(last_name);
	}//end main
}//end Run
