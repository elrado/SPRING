/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.validation;

import org.springframework.core.convert.converter.Converter;
/**
 *
 * @author radoo
 */
public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact>{

	@Override
	public AnotherContact convert(Contact c) {
		AnotherContact ac = new AnotherContact();
		ac.setBirthDate(c.getBirthDate());
		ac.setPersonalSite(c.getPersonalSite());
		ac.setFirstName(c.getLastName());
		ac.setLastName(c.getFirstName());
		return ac;
	}

}//end ContactToAnotherContactConverter
