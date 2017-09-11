/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import org.springframework.core.task.TaskExecutor;

/**
 *
 * @author radoo
 */
public class TaskToExecute {

	private TaskExecutor taskExecutor;

	public void executeTask() {
		for (int i = 0; i < 10; i++) {
			taskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Hello from thread: "
						+ Thread.currentThread().getName());
				}//end run
			});
		}//end for
	}//end executeTask

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}//setTaskExecutor
}//end TaskToExecute
