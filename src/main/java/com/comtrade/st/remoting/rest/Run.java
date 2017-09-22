/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.rest;

import com.comtrade.st.remoting.*;
import java.net.MalformedURLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	public static void main(String[] args) throws MalformedURLException {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		ContactService contactService = (ContactService) ctx.getBean("contactService", ContactService.class);
		

		List<Contact> contacts = contactService.findAll();
		for (Contact cnt : contacts){
			System.out.println(cnt.toString());
		}
	}//end main
}//end Run
