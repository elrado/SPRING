/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import java.security.MessageDigest;
import javax.annotation.Resource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

	private String alghoritmName = "MD5";

	private MessageDigest messageDigest = null;

	@Override
	public MessageDigest getObject() throws Exception {
		return this.messageDigest;
	}

	@Override
	public Class<?> getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.messageDigest = MessageDigest.getInstance(this.alghoritmName);
	}
	
	public void setAlghoritmName(String alghoritmName) {
		this.alghoritmName = alghoritmName;
	}
}
