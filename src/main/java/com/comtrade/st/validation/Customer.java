/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author radoo
 */
@CheckIndividualCustomer(message = "{errors.customer.lastName.defined}")
public class Customer {

	@NotNull
	@Size(min = 3,max = 60, message = "{errors.customer.firstName.size}")
	private String firstName;
	private String lastName;
	@NotNull(message = "{errors.customer.clientType.notNull}")
	private CustomerType customerType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
}//end Customer
