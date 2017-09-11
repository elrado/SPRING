/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class RunAsync {

	private static final Logger logger = Logger.getLogger(RunAsync.class);

	public static void main(String[] args) throws MalformedURLException {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		System.out.println("*****************************************Spring task scheduling asyncService**********************************************");
		AsyncService asyncService = (AsyncService) ctx.getBean("asyncService", AsyncService.class);

		for (int i = 0; i < 5; i++) {
			asyncService.asyncTask();
		}

		Future<String> result1 = asyncService.asyncWithReturn("Chris");
		Future<String> result2 = asyncService.asyncWithReturn("John");
		Future<String> result3 = asyncService.asyncWithReturn("Robert");

		try {
			Thread.sleep(6000);
			System.out.println("Result1: " + result1.get());
			System.out.println("Result2: " + result2.get());
			System.out.println("Result3: " + result3.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}//end main
}//end Run
