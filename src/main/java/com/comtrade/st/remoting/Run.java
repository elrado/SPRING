/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting;

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
		ContactService remoteContactService = (ContactService) ctx.getBean("remoteContactService", ContactService.class);
		

		Contact c = new Contact();
		c.setFirstName("Rado");
		c.setLastName("Osredkar");
		c.setBirthDate(new DateTime(1977,5,6,4,15));
		contactService.save(c);

		List<Contact> contacts = contactService.findAll();
		for (Contact cnt : contacts){
			System.out.println(cnt.toString());
		}
		/* pom.xml=>right click=>Rum Maven=>Goals=>compile war:war */
		/*V dependency nujno dodaj servlet-api + Contact mora biti Serializable*/
		System.out.println("****************************************** remoteContactServices **********************************");
		List<Contact> remoteContactServices = remoteContactService.findAll();
		contacts = remoteContactService.findAll();
		for (Contact cnt : contacts){
			System.out.println(cnt.toString());
		}

		
		
	}//end main
}//end Run
