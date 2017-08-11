/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.aop.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author radoo
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.comtrade.st.aop.aspectj")
public class Config {

}//end Config
