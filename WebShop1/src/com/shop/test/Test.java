package com.shop.test;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.shop.service.impl.ServiceManager;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml");
//		com.shop.service.impl.ServiceManager sm = (ServiceManager) ctx.getBean("ServiceManager");
//		System.out.print(sm);
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ServiceManager serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		Method m[] = serviceManager.getClass().getDeclaredMethods();
		for(int i = 0;i<m.length; i++){
			System.out.println(m[i].getName());
		}
	}

}
