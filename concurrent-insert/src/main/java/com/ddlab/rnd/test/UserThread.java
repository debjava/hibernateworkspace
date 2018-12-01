package com.ddlab.rnd.test;

import java.util.List;
import java.util.concurrent.Callable;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.service.IUserService;

public class UserThread implements Callable<UserEntity> {

	private IUserService userService;
	private UserEntity userEntity;
	private List<UserEntity> users;

	public UserThread(IUserService userService) {

		this.userService = userService;
	}
	
	public UserThread(IUserService userService, List<UserEntity> users) {

		this.userService = userService;
		this.users = users;
	}

	public UserThread(IUserService userService,UserEntity userEntity) {

		this.userService = userService;
		this.userEntity = userEntity;
	}

	public void createUser() {
		userEntity = RandomGenerator.getRandomUser();
	}
	
	public UserEntity call() throws Exception {
//		TimeUnit.MILLISECONDS.sleep(700);
		try {
//			if( userEntity == null ) 
//				createUser();
//			userService.save(userEntity);
			System.out.println("Thread Users ----------->"+users);
			userService.saveAll(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
