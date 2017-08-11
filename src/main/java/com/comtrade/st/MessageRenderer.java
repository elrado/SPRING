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
@Service("messageRenderer")
public class MessageRenderer {
	private MessageProvider messageProvider;
	@Value("#{injectSimpleConfig.message}")
	private String message;

	public void render(){
		System.out.println(messageProvider.getMessage());
		messageProvider.setMessage("Hello world");
		System.out.println(messageProvider.getMessage());
		System.out.println(message);
	}//end render

	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	@Autowired
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}


}//end MessageRenderer
