/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting;

import java.util.List;

/**
 *
 * @author radoo
 */
public interface ContactService {

	List<Contact> findAll();

	List<Contact> findByFirstName(String firstName);

	Contact findById(Long id);

	Contact save(Contact contact);

	void delete(Contact contact);
}//end ContactService
