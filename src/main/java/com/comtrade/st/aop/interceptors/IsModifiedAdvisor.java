/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.interceptors;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 *
 * @author radoo
 */
public class IsModifiedAdvisor extends  DefaultIntroductionAdvisor{
	
	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}//ned IsModifiedAdvisor
}//end IsModifiedAdvisor
