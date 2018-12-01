package com.ddlab.rnd.orm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestQuery {

	public static void showCustomer(Session session) {
		try {
			String hql = "FROM BankCustomer";
//			String hql = "FROM BankCustomer bc , BankAccount ba where bc.custId = ba.actId";
			Query query = session.createQuery(hql);
			List results = query.list();
			for( int i = 0 ; i < results.size() ; i++) {
				BankCustomer cust = (BankCustomer) results.get(i);
				System.out.format("%10s%10s\n", cust.getCustId(),cust.getName());
				System.out.println(cust.getAccounts());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showCustomer1(Session session) {
		try {
//			String hql = "FROM BankCustomer";
			String hql = "Select bc.custId, bc.name FROM BankCustomer bc , BankAccount ba where bc.custId = ba.actId";
			Query query = session.createQuery(hql);
			List results = query.list();
			for( int i = 0 ; i < results.size() ; i++) {
//				String s = (String) results.get(i);
//				System.out.println(s);
				System.out.println(results.get(i).toString());
//				System.out.println(results.get(i).getClass());
//				BankCustomer cust = (BankCustomer) results.get(i);
//				System.out.format("%10s%10s\n", cust.getCustId(),cust.getName());
//				System.out.println(cust.getAccounts());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		
//		showCustomer(session);
		
		showCustomer1(session);
	}

}
