package com.ddlab.rnd.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.service.IUserService;

public class Test1 {

	public void insert(IUserService userService) {

		try {
			UserEntity user = RandomGenerator.getRandomUser();
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		IUserService userService = (IUserService) context.getBean("userService");
		Test1 test = new Test1();
		test.insert(userService);
		System.out.println("All insertions over.....");

	}
}
