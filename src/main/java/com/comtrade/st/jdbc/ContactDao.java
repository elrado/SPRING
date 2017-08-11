/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.jdbc;

import java.util.List;

/**
 *
 * @author radoo
 */
public interface ContactDao {
	String findLastNameById(Long id);
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
}//end ContactDao
