/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.Events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@PropertySource("classpath:resource.properties")
public class EventPublisher implements ApplicationContextAware{

	private ApplicationContext ctx;

	private String message;

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		this.ctx = ac;
	}

	public void publish(String message){
		ctx.publishEvent(new MessageEvent(this, message));
	}

	@Value("${message:no message}")
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = 
			new AnnotationConfigApplicationContext(AppConfig.class);
		EventPublisher pub = (EventPublisher)ctx.getBean("publisher");
		pub.publish("Pozdravljen svet!");
		pub.publish("Tralala hopsasa");
		pub.publish(pub.message);

		Resource res = ctx.getResource("classpath:resource.txt");
		if (res.exists()){
		    try{
			  InputStream is = res.getInputStream();
			  BufferedReader br = new BufferedReader(new InputStreamReader(is));

			  String line;
			  while ((line = br.readLine()) != null) {
				pub.publish(line);
			  }
			  br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		    }			
		}
	}
