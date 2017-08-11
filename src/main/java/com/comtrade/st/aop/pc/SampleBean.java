/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.aop.pc;

/**
 *
 * @author radoo
 */
public class SampleBean {
	private String p1;	
	private String p2;	
	public void foo(int x){
		System.out.println("Invoked foo with:" + x);	
	}

	@AdviceRequired
	public void bar(){
		System.out.println("invoked bar");
	}

	public String getP1() {
		System.out.println("com.comtrade.st.aop.pc.SampleBean.getP1()");
		return p1;
	}

	public void setP1(String p1) {
		System.out.println("com.comtrade.st.aop.pc.SampleBean.setP1()");
		this.p1 = p1;
	}

	public String getP2() {
		System.out.println("com.comtrade.st.aop.pc.SampleBean.getP2()");
		return p2;
	}

	public void setP2(String p2) {
		System.out.println("com.comtrade.st.aop.pc.SampleBean.setP2()");
		this.p2 = p2;
	}

}
