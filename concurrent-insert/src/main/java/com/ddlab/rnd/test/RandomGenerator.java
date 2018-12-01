package com.ddlab.rnd.test;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.ddlab.rnd.entity.UserEntity;

public class RandomGenerator {

	private static SecureRandom random = new SecureRandom();

	public static String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	public static UserEntity getRandomUser() {
		String name = nextSessionId();
		return new UserEntity(name);
	}

}
