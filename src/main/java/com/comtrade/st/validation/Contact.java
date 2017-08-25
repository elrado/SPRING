/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

import com.comtrade.st.hibernate.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.net.URL;
import org.joda.time.DateTime;

public class Contact implements Serializable {

	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private URL personalSite;

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

	public DateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	public URL getPersonalSite() {
		return personalSite;
	}

	public void setPersonalSite(URL personalSite) {
		this.personalSite = personalSite;
	}

	@Override
	public String toString() {
		return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", personalSite=" + personalSite + '}';
	}
}//end Contact
