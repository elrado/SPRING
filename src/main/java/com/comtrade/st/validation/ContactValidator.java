/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.validation;

import org.joda.time.DateTime;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author radoo
 */
public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> type) {
		return Contact.class.equals(type);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "Firstname.empty");
		Contact c = (Contact)o;
		if ( (DateTime.now().getYear() - c.getBirthDate().getYear())<18){
			errors.reject("Too young");
		}
	}

}//end ContactValidator
