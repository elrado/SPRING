/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;


/**
 *
 * @author radoo
 */
public class DeclareComponents {
	public static void main(String[] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();

		MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();

		CollectionProvider cprov = (CollectionProvider) ctx.getBean("collectionProvider");
		for (String c : cprov.getList()){
			System.out.println(c);
		}

		bnSingleton s1 = ctx.getBean("singleton", bnSingleton.class);
		bnSingleton s2 = ctx.getBean("singleton", bnSingleton.class);

		bnnonSingleton ns1 =  ctx.getBean("nonsingleton", bnnonSingleton.class);
		bnnonSingleton ns2 =  ctx.getBean("nonsingleton", bnnonSingleton.class);

		System.out.println( s1 == s2 );
		System.out.println(bnSingleton.st);
		System.out.println( ns1 == ns2 );
		System.out.println(bnnonSingleton.st);

		MessageDigest digest1 =  ctx.getBean("digest1", MessageDigest.class);
		digest1.digest();

		PropertyEditorBean builtInSample = ctx.getBean("builtInSample", PropertyEditorBean.class);
		//builtInSample.setBytes("tralal".getBytes());
		builtInSample.setAsText("tralal");

		try {
		} catch (Exception ex) {
			Logger.getLogger(DeclareComponents.class.getName()).log(Level.SEVERE, null, ex);
		}


		ctx.destroy();


	}//end main
}//end DeclareComponents
