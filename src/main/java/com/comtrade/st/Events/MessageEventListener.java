/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.Events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

	@Override
	public void onApplicationEvent(MessageEvent e) {
		MessageEvent msgEvt = (MessageEvent) e;
		System.out.println("Received: " + msgEvt.getMsg());
	}
}
