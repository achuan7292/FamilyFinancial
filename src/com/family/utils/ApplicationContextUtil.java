package com.family.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
 
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
 
	public void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextUtil.applicationContext = applicationContext;
	}
 
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

}