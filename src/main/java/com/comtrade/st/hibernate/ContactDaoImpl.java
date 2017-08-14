/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.hibernate;

import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radoo
 */
@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);
	private SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	@Override
	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession()
			.getNamedQuery("Contact.findAllWithDetail").list();
	}

	@Override
	public Contact findById(Long id) {
		return null;
	}

	@Override
	public Contact save(Contact contact) {
		return null;
	}

	@Override
	public void delete(Contact contact) {
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}//end ContactDaoImpl
