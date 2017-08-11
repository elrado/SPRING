/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
public class JdbcContactDao implements ContactDao, InitializingBean {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public String findLastNameById(Long id) {
		/*
		return jdbcTemplate.queryForObject(
			"SELECT first_name FROM contact WHERE id = ?",
			new Object[]{id}, String.class);
		*/

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("contactId", id);
		return namedParameterJdbcTemplate.queryForObject(
			"SELECT first_name FROM contact WHERE id = :contactId", 
			namedParameters,
			String.class
		);
	}//end findLastNameById

	@Override
	public List<Contact> findAll() {
		String sql = "select id, first_name, last_name, birth_date from contact";
		return namedParameterJdbcTemplate.query(
			sql, 
			(rs, rowNum) -> {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setFirstName(rs.getString("first_name"));
				contact.setLastName(rs.getString("last_name"));
				contact.setBirthDate(rs.getDate("birth_date"));
				return contact;
			});
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}
		if (jdbcTemplate == null) {
			throw new BeanCreationException("Null JdbcTemplate on ContactDao");
		}
	}
}//end JdbcContactDao
