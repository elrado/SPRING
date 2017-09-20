/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting.jms;

import com.comtrade.st.remoting.*;
import java.net.MalformedURLException;
import java.net.URI;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	public static void main(String[] args) throws MalformedURLException, Exception {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);

		ActiveMQConnectionFactory connectionFactory = ctx.getBean("connectionFactory", ActiveMQConnectionFactory.class);
		BrokerService broker = new BrokerService();

		TransportConnector connector = new TransportConnector();
		connector.setUri(new URI("tcp://localhost:61616"));//Embeded
		broker.addConnector(connector);
		broker.start();
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		for (int i = 0; i < 10; i++) {
			messageSender.sendMessage("Test message: " + i);
		}
	}//end main
}//end Run
