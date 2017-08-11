/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author radoo
 */
@Component
@Aspect
public class MyAdvice {
	/**
	 * <p>
	 * desc     
	 * </p>
	 * @param  intValue  int   
	 * Changes:
	 * @author Rado date  created  
	 */
	@Pointcut("execution(* com.comtrade.st.aop.aspectj..foo*(int)) && args(intValue)")
	public void fooExecution(int intValue) {
	}//end fooExecution

	/**
	 * <p>
	 * desc     
	 * </p>
	 * Changes:
	 * @author author_name date  created  
	 */
	@Pointcut("bean(myDependency*)")
	public void inMyDependency() {
	}//end inMyDependency

	/**
	 * <p>
	 * desc     
	 * </p>
	 * Changes:
	 * @author author_name date  created  
	 */
	@Before("fooExecution(intValue) && inMyDependency()")
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		if(intValue != 100){
			System.out.println("Executing: " +
				joinPoint.getSignature().getDeclaringTypeName() + " "
				+ joinPoint.getSignature().getName()+ " argument: " + intValue);
		}//end if
	}//end simpleBeforeAdvice

	/**
	 * <p>
	 * desc     
	 * </p>
	 * @param  param  param_desc   
	 * @return return_desc   
	 * Changes:
	 * @author author_name date  created  
	 */
	public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
		System.out.println("Before execution:"  
			+ pjp.getSignature().getDeclaringTypeName() + " "
			+ pjp.getSignature().getName()+ " argument: " + intValue);
		
		Object retVal = pjp.proceed();

		System.out.println("After execution: "
			+ pjp.getSignature().getDeclaringTypeName() + " "
			+ pjp.getSignature().getName()+ " argument: " + intValue);

		return retVal;
	}//end simpleAroundAdvice
}//end MyAdvice
