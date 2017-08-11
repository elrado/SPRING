/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import org.springframework.stereotype.Component;

/**
 *
 * @author radoo
 */
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
	private String message = "from inject sample config, if there is not property named message set in context xml";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
