/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.aop.aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author radoo
 */
@Component("myBean")
public class MyBean {
	private MyDependency myDependency;

	/**
	 * <p>
	 * desc     
	 * </p>
	 * Changes:
	 * @author author_name date  created  
	 */
	public   void execute() {
		myDependency.foo(100);
		myDependency.foo(101);
		myDependency.bar();
	}//end execute

	@Autowired
	public void setMyDependency(MyDependency myDependency) {
		this.myDependency = myDependency;
	}
}//end MyBean
