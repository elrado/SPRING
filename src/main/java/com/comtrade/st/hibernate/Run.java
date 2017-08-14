/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.hibernate;

import com.comtrade.st.jdbc.*;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
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
		System.out.println("****************************contacts findById********************************************");
		Contact contact = contactDao.findById(4L);
		System.out.println("Listing contact with id 4");
		System.out.println(contact);


		System.out.println("****************************contacts insert********************************************");

		contact = new Contact();
		contact.setFirstName("Vladka");
		contact.setLastName("Osredkar");
		contact.setBirthDate(new Date());
		System.out.println(contact);

		System.out.println("****************************contacts update********************************************");
		
		contact.setBirthDate(Date.from(LocalDate.parse("1980-07-01").atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contact = contactDao.save(contact);
		System.out.println(contact);

		System.out.println("****************************contacts delete********************************************");
		System.out.println("Before deletion " + contactDao.findAll().size());
		contactDao.delete(contact);
		System.out.println("After deletion " + contactDao.findAll().size());
		
	}//end main
}//end Run
