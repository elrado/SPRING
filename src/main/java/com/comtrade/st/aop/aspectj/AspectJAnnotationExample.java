/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class AspectJAnnotationExample {
	public static void main(String[] args) {
		ApplicationContext ctx = 
			new AnnotationConfigApplicationContext(Config.class);		
		MyBean myBean = (MyBean)ctx.getBean("myBean");
		myBean.execute();
	}//end main
}//end AspectJAnnotationExample
