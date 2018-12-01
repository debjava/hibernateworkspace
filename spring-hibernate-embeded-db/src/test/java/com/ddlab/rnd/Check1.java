package com.ddlab.rnd;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Check1 {
	
	private static ApplicationContext context = null;
	private static PersonService service = null;
	
	@BeforeClass
	public static void init() {
		new Check1().doSetup();
	}
	
	public void doSetup() {
		context = new ClassPathXmlApplicationContext("testBeans.xml");
		service = (PersonService) context.getBean("personService");
		System.out.println("Service :::"+service);
	}
	
	@Test
	public void test1() {
		Person p = new Person("Deb");
		service.store(p);
		assertEquals(1,service.getPersonList());
	}
}
