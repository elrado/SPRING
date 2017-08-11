/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.Events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 *
 * @author radoo
 */
@Configuration
@PropertySource(value="classpath:resource.properties")
@ComponentScan(basePackages = "com.comtrade.st")
public class AppConfig {
	@Autowired
	Environment env;

	@Bean
	@Lazy(value = true)
	MessageEventListener messageEventListener(){
		//System.out.println(env.getProperty("message"));
		return new MessageEventListener();
	}

	@Bean
	@Lazy(value = true)
	EventPublisher publisher (){
		//System.out.println(env.getProperty("message"));
		return new EventPublisher();
	}
}
