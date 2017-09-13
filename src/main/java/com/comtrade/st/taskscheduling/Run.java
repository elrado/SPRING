/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import java.net.MalformedURLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author radoo
 */
public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	public static void main(String[] args) throws MalformedURLException {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		System.out.println("*****************************************Spring task scheduling**********************************************");
		CarService carService = (CarService) ctx.getBean("carService", CarService.class);
		TaskToExecute taskToExecute = (TaskToExecute) ctx.getBean("taskToExecute", TaskToExecute.class);

		List<Car> cars = carService.findAll();
		for (Car car : cars) {
			System.out.println(car.toString());
		}

		taskToExecute.executeTask();

	}//end main
}//end Run
