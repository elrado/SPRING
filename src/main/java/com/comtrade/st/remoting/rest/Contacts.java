/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.rest;

import com.comtrade.st.remoting.Contact;
import java.io.Serializable;
import java.util.List;

public class Contacts implements Serializable {

	private List<Contact> contacts;

	public Contacts() {
	}

	public Contacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
