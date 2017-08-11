/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service("messageProvider")
public class MessageProvider {
	private String message;

	public String getMessage() {
		return message;
	}

	@Autowired
	public void setMessage(@Value("Configure message") String message) {
		this.message = message;
	}
}
