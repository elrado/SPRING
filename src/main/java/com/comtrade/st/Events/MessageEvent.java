/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.Events;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author radoo
 */
public class MessageEvent extends ApplicationEvent{

	private String msg;
	
	public MessageEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
