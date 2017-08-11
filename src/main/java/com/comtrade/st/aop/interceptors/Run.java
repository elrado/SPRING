/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.interceptors;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author radoo
 */
public class Run {
	public static void main(String[] args) {
		TargetBean target =new TargetBean();
		target.setName("Rado Osredkar");
		
		IntroductionAdvisor advisor = new IsModifiedAdvisor();
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setOptimize(true);
		
		TargetBean proxy = (TargetBean) pf.getProxy();
		IsModified proxyInterface = (IsModified)proxy;

		System.out.println("Is TargetBean?:" + (proxy instanceof TargetBean));
		System.out.println("Is IsModified?:" + (proxy instanceof IsModified));

		System.out.println("Has been modified?: " + 
			proxyInterface.isModified());

		proxy.setName("Vladka Osredkar");

		System.out.println("Has been modified?: " + 
			proxyInterface.isModified());
	}//end main
}//end Run
