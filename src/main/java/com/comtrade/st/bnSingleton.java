/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service("singleton")
public class bnSingleton implements BeanNameAware {
	public static int st = 0;

	public bnSingleton() {
		st +=1;
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("bnSingleton Initialized");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("bnSingleton destroyed");
	}

	@Override
	public void setBeanName(String string) {
		System.out.println("bnSingleton name " + string);
	}
}
