/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author radoo
 */
public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	enum eTestType {
		a,
		b,
		c
	}

	public static void main(String[] args) throws MalformedURLException {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		Contact contact = (Contact) ctx.getBean("contact");
		ConversionService conversionService = (ConversionService) ctx.getBean("conversionService");
		DefaultFormattingConversionService acf = (DefaultFormattingConversionService) ctx.getBean("applicationConversionServiceFactoryBean");
		Validator contactValidator = ctx.getBean("contactValidator", Validator.class);
		contact.setPersonalSite(new URL("http://www.dtzq.com"));
		contact.setBirthDate(
			conversionService.convert("6.5.1977", DateTime.class));
		System.out.println(contact.toString());

		System.out.println(
			conversionService.convert(contact, AnotherContact.class)
		);
		System.out.println(
			conversionService.convert(contact, AnotherContact.class)
		);

		//IntegerToEnum
		System.out.println(eTestType.a);
		System.out.println(
			conversionService.convert(eTestType.b, Integer.class)
		);

		System.out.println("*****************************************Formatters**********************************************");
		System.out.println(
			acf.convert(contact.getBirthDate(), String.class)
		);
		System.out.println(
			acf.convert("12.8.2017", DateTime.class)
		);
		System.out.println("*****************************************Validators**********************************************");
		contact = new Contact();
		contact.setFirstName(null);
		contact.setLastName("Schaefer");
		contact.setBirthDate(acf.convert("12.8.2017", DateTime.class));

		BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Chris");

		ValidationUtils.invokeValidator(contactValidator, contact, result);
		List<ObjectError> errors = result.getAllErrors();
		System.out.println("No of validation errors: " + errors.size());
		for (ObjectError error : errors) {
			System.out.println(error.getCode());
		}

	}//end main
}//end Run
