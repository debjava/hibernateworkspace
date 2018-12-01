package com.ddlab.rnd.test;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.service.IUserService;

public class Test {

	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	public UserEntity getUserEntity() {

		return new UserEntity(nextSessionId());
	}

	public void insertSimultaneously(IUserService userService) {

		try {
			List<UserThread> threadsList = new ArrayList<UserThread>();

			for(int i = 0 ; i < 200 ; i++) {
				//				UserThread th = new UserThread(userService,getUserEntity());
				UserThread th = new UserThread(userService);
				threadsList.add(th);
			}
			ExecutorService exService = Executors.newFixedThreadPool(50);
			exService.invokeAll(threadsList);

			exService.shutdown();

			System.out.println("Over ..........");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertTwo(IUserService userService) {

		try {
			List<UserThread> threadsList = new ArrayList<UserThread>();
			UserEntity user = getUserEntity();
			for(int i = 0 ; i < 2 ; i++) {
				UserThread th = new UserThread( userService,user );
				threadsList.add(th);
			}
			ExecutorService exService = Executors.newFixedThreadPool(50);
			exService.invokeAll(threadsList);

			exService.shutdown();

			System.out.println("Over ..........");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertFour(IUserService userService) {

		try {
			List<UserThread> threadsList = new ArrayList<UserThread>();
			UserEntity user = getUserEntity();
			List<UserEntity> users = new ArrayList<UserEntity>();
			users.add(user);
			users.add(user);
			user = getUserEntity();
			users.add(user);
			users.add(user);
			for(int i = 0 ; i < 2 ; i++) {
//				List<UserEntity> users = new ArrayList<UserEntity>();
//				user = getUserEntity();
//				users.add(user);
//				user = getUserEntity();
//				users.add(user);
//				System.out.println("=============>"+users);
				UserThread th = new UserThread( userService,users );
				threadsList.add(th);
			}
			ExecutorService exService = Executors.newFixedThreadPool(50);
			exService.invokeAll(threadsList);

			exService.shutdown();

			System.out.println("Over ..........");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		IUserService userService = (IUserService) context.getBean("userService");
		//		TimeUnit.SECONDS.sleep(30);
		Test test = new Test();
		test.insertFour(userService);

		System.out.println("All insertions over.....");

	}
}
