/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.hibernate;

import com.comtrade.st.jdbc.*;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	public static void main(String[] args) {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		ContactDao contactDao = (ContactDao) ctx.getBean("contactDao", ContactDao.class);

		//List all contacts
		List<Contact> contacts = contactDao.findAll();
		Set<ContactTelDetail> contactTelDetails;

		System.out.println("****************************contacts********************************************");
		for (Contact c : contacts) {
			System.out.println("Listing all contacts with details");
			System.out.println(c);
		}

		contacts = contactDao.findAllWithDetail();
		System.out.println("****************************contacts with details********************************************");
		//List all contacts with details
		for (Contact c : contacts) {
			System.out.println("Listing all contacts with details");
			System.out.println(c);
			contactTelDetails = c.getContactTelDetails();
			if (contactTelDetails != null) {
				for (ContactTelDetail cd : contactTelDetails) {
					System.out.print("	");
					System.out.println(cd);
				}//end for
				if (c.getHobbies() != null) {
					for (Hobby hobby : c.getHobbies()) {
						System.out.println(hobby);
					}
				}
			}//end if
		}
	}//end main
}//end Run
