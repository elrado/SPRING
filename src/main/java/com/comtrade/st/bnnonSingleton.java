/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service("nonsingleton")
@Scope("prototype")
public class bnnonSingleton implements InitializingBean, DisposableBean, ApplicationContextAware {
	
	public static int st = 0;

	public bnnonSingleton() {
		st +=1;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bnnonSingleton Initialized");
	}
	
	public void destroy() throws Exception {
		System.out.println("bnnonSingleton destroyed");
	}

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		if (ac instanceof GenericApplicationContext){
			((GenericApplicationContext) ac).registerShutdownHook();
		}
	}
}
