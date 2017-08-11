/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 *
 * @author radoo
 */
@Component("myDependency")
public class MyDependency {
	/**
	 * <p>
	 * desc     
	 * </p>
	 * @param  intValue     
	 * Changes:
	 * @author author_name  created  
	 */
	public void foo(int intValue) {
		System.out.println("foo(int):" + intValue);	
	}//end foo

	/**
	 * <p>
	 * desc     
	 * </p>
	 * Changes:
	 * @author author_name date  created  
	 */
	public   void bar() {
		System.out.println("bar()");
	}//end bar
}//end MyDependency
