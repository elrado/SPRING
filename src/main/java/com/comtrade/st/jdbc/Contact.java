/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.jdbc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Contact implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<ContactTelDetail> contactTelDetails;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}

	public List<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String toString() {
		return "Contact - Id: " + id + ", First name: " + firstName
			+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
