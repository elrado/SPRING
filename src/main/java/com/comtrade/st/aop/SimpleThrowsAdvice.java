/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author radoo
 */
public class SimpleThrowsAdvice implements ThrowsAdvice{
	public static void main(String[] args) {
		ErrorBean errorBean = new ErrorBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowsAdvice());
		ErrorBean proxy = (ErrorBean) pf.getProxy();
		try {
			proxy.errorProneMethod();
		} catch (Exception ex) { }
		try {
			proxy.otherErrorProneMethod();
		} catch (Exception ignored) { }		
	}

	public void afterThrowing (Exception ex) {
		System.out.println("***");
		System.out.println("Generic Exception Capture");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("***\n");		
	}
}
