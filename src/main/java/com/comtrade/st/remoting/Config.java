/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.remoting;

import com.comtrade.st.remoting.jms.SimpleMessageListener;
import com.comtrade.st.taskscheduling.*;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author radoo
 */
@Configuration
@PropertySource(value = "classpath:resource.properties")
@ComponentScan(basePackages = "com.comtrade.st.remoting")
@EnableJpaRepositories(entityManagerFactoryRef = "emfactory")/**/
@EnableScheduling
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Bean("dataSource")
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("shema.sql")
			.addScript("test-data.sql")
			.build();
		return db;
	}//end datasource		

	@Bean("emfactory")
	public LocalContainerEntityManagerFactoryBean emfactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) throws IOException {
		LocalContainerEntityManagerFactoryBean emfactory = new LocalContainerEntityManagerFactoryBean();
		emfactory.setDataSource(dataSource);
		emfactory.setJpaVendorAdapter(jpaVendorAdapter);
		emfactory.setPackagesToScan("com.comtrade.st.remoting");
		return emfactory;
	}//end LocalContainerEntityManagerFactoryBean

	@Bean("jpaVendorAdapter")
	JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.H2);
		return hibernateJpaVendorAdapter;
	}

	@Bean("transactionManager")
	JpaTransactionManager transactionManager(EntityManagerFactory emf, DataSource dataSource) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSource);
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}

	@Bean("contactExporter")
	HttpInvokerServiceExporter contactExporter(ContactService contactService) {
		HttpInvokerServiceExporter contactExporter = new HttpInvokerServiceExporter();
		contactExporter.setService(contactService);
		contactExporter.setServiceInterface(ContactService.class);

		return contactExporter;
	}//end contactExporter

	@Bean("remoteContactService")
	HttpInvokerProxyFactoryBean remoteContactService() {
		HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
		httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8084/ST/remoting/ContactService");
		httpInvokerProxyFactoryBean.setServiceInterface(com.comtrade.st.remoting.ContactService.class);
		return httpInvokerProxyFactoryBean;
	}

	//JMS
	SimpleMessageListener simpleMessageListener() {
		return new SimpleMessageListener();
	}

	@Bean("connectionFactory")
	ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activemqCF = new ActiveMQConnectionFactory();
		activemqCF.setBrokerURL("tcp://localhost:61616");//embeded
		//activemqCF.setBrokerURL("tcp://localhost:8161");
		return activemqCF;
	}

	@Bean("consumerJmsListenerContainer")
	DefaultMessageListenerContainer consumerJmsListenerContainer() {
		DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
		dmlc.setConnectionFactory(connectionFactory());
		MessageListenerAdapter listener = new MessageListenerAdapter();
		listener.setDelegate(new SimpleMessageListener());
		listener.setDefaultListenerMethod("onMessage");
		dmlc.setDestinationName("prospring4");
		dmlc.setMessageListener(listener);
		return dmlc;
	}

	@Bean("jmsTemplate")
	JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory) {
		JmsTemplate jt = new JmsTemplate(connectionFactory);
		jt.setDefaultDestinationName("prospring4");
		return jt;
	}

}//end Config
