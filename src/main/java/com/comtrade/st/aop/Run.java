/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop;

import java.lang.reflect.Method;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author radoo
 */
public class Run implements MethodBeforeAdvice {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.addAdvice(new Run());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter)pf.getProxy();

		target.writeMessage();
		System.out.println("");
		proxy.writeMessage();

		//Before advice
		
		

	}//end main

	@Override
	public void before(Method method, Object[] os, Object o) throws Throwable {
		System.out.println("Before method: " + method.getName());
	}
}//end rum
