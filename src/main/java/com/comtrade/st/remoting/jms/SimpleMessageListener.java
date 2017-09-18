/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author radoo
 */
public class SimpleMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

	@Override
	public void onMessage(Message msg) {
		TextMessage textMessage = (TextMessage) msg;
		try {
			logger.info("Message received: " + textMessage.getText());
		} catch (JMSException ex) {
			logger.error("JMS error", ex);
		}
	}

}//end SimpleMessageListener
