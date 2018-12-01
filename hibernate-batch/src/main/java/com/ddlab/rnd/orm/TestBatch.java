package com.ddlab.rnd.orm;

import org.hibernate.HibernateException;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBatch {

	public static void bulkInsert(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < 3000; i++) {
				Employee employee = new Employee("Name-" + i, "City-" + i);
				session.save(employee);
				// Otherwise it will throw OutOfMemory Error
				if (i % 1000 == 0) {
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void bulkUpdate(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			ScrollableResults empResults = session.createQuery("FROM Employee")
					.scroll();
			int count = 0;
			while (empResults.next()) {
				Employee employee = (Employee) empResults.get(0);
				employee.setCity("My City-" + count);
				count++;
				session.update(employee);
				// Otherwise it will throw OutOfMemory Error
				if (count % 1000 == 0) {
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");

		Session session = sessionFactory.openSession();

		bulkInsert(session);

		bulkUpdate(session);
	}

}
