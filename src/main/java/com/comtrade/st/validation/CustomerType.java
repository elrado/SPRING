/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.validation;

/**
 *
 * @author radoo
 */
public enum CustomerType {
	INDIVIDUAL("I"), CORPORATE("C");
	private String code;

	private CustomerType(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}
}
