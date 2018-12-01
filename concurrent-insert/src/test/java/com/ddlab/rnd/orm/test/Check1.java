package com.ddlab.rnd.orm.test;

import java.lang.annotation.Annotation;
import java.math.BigInteger;

import org.hibernate.annotations.Check;

public class Check1 {
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	public static void main(String[] args) {
		Check1.permutation("abcdefghijk");
//		System.out.println(Check1.permutation("abc")) ;

	}

}
