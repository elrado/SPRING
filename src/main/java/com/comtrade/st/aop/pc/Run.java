/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.pc;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 *
 * @author radoo
 */
public class Run {
	public static void main(String[] args) {
		BeanOne one = new BeanOne();
		BeanTwo two = new BeanTwo();

		BeanOne proxyOne;
		BeanTwo proxyTwo;

		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

		ProxyFactory pf =new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(one);
		proxyOne = (BeanOne) pf.getProxy();

		pf =new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(two);
		proxyTwo = (BeanTwo) pf.getProxy();
		System.out.println("******************** SimpleStaticPointcut********************");
		proxyOne.foo();
		proxyTwo.foo();

		proxyOne.bar();
		proxyTwo.bar();

		//Dynamic pointcut
		SampleBean target = new SampleBean();
		advisor = new DefaultPointcutAdvisor(new SimpleDinamicPointcut(), new SimpleAdvice());

		pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);

		SampleBean proxy = (SampleBean) pf.getProxy();
		System.out.println("******************** SimpleDinamicPointcut********************");
		proxy.foo(1);
		proxy.foo(10);
		proxy.foo(100);

		proxy.bar();


		System.out.println("******************** JdkRegexpMethodPointcut********************");
		JdkRegexpMethodPointcut pcr = new JdkRegexpMethodPointcut();
		pcr.setPattern(".*get.*");
		advisor =  new DefaultPointcutAdvisor(pcr, advice);
		pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		proxy = (SampleBean) pf.getProxy();
		proxy.foo(100);
		proxy.getP1();
		proxy.setP1("OK");
		proxy.getP2();
		proxy.setP2("OK");

		//annonation based advice
		System.out.println("******************** AnnotationMatchingPointcut********************");
		AnnotationMatchingPointcut pca = AnnotationMatchingPointcut
			.forMethodAnnotation(AdviceRequired.class);
		advisor = new DefaultPointcutAdvisor(pca, advice);
		pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		proxy = (SampleBean) pf.getProxy();

		proxy.getP1();
		proxy.bar();
	}
}
