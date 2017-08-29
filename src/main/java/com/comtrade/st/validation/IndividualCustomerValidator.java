/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author radoo
 */
public class IndividualCustomerValidator implements
ConstraintValidator<CheckIndividualCustomer, Customer> {

	@Override
	public boolean isValid(Customer customer, ConstraintValidatorContext cvc) {
		boolean result = true;
		if (
			customer.getCustomerType() != null &&
			(customer.getLastName() == null)
			)
		{
			result = false;	
		}
		return result;
	}

}//end IndividualCustomerValidator
