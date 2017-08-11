/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.util.StopWatch;

/**
 *
 * @author radoo
 */
public class MessageDecorator implements MethodInterceptor, AfterReturningAdvice {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		StopWatch sw = new StopWatch();
		System.out.print("Hello ");
		sw.start(mi.getMethod().getName());
		Object retVal = mi.proceed();
		sw.stop();
		System.out.println("Trajanje:" + sw.getTotalTimeMillis());
		System.out.println("!");
		return retVal;
	}

	@Override
	public void afterReturning(Object o, Method method, Object[] os, Object o1) throws Throwable {
		System.out.println("afterReturning");
	}
	
}
