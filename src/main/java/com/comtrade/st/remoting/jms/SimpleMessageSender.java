/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *
 * @author radoo
 */
@Component("messageSender")
public class SimpleMessageSender implements MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(String message) {
		this.jmsTemplate.send((Session sn) -> sn.createTextMessage(message));
	}

}//end SimpleMessageSender
