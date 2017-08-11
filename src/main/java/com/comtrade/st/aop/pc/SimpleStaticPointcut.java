/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.pc;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 *
 * @author radoo
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> type) {
		return ("foo".equalsIgnoreCase(method.getName()));
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class<?> cls){
				return BeanOne.class == cls;
			}
		};
	}
}
