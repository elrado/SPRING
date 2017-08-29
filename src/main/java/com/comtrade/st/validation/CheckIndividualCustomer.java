/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author radoo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)/* annotation should be applied only at the class level*/
@Constraint(validatedBy = IndividualCustomerValidator.class)/*it’s a validator, and the validatedBy attribute specifies the class providing the validation logic*/
@Documented
public @interface CheckIndividualCustomer {

	String message() default "Individual customer should have gender and last name defined";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}//end CheckIndividualCustomer
