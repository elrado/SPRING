/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

	final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

	@Override
	@Async
	public void asyncTask() {
		logger.info("Start execution of async. task");
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Complete execution of async. task");
	}

	@Override
	@Async
	public Future<String> asyncWithReturn(String name) {
		logger.info("Start execution of async. task with return");
		try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Complete execution of async. task with return");
		return new AsyncResult<String>("Hello: " + name);
	}

}//end AsyncServiceImpl
