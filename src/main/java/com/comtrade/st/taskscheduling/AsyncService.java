/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import java.util.concurrent.Future;

/**
 *
 * @author radoo
 */
public interface AsyncService {

	void asyncTask();

	Future<String> asyncWithReturn(String name);
}//end AsyncService
