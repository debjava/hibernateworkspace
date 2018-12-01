package com.ddlab.rnd.orm.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class App.
 * @author Debadatta Mishra
 */
public class App {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Customer cust = new Customer();
			cust.setFirstName("Deb1");
			cust.setLastName("Mishra1");

			Address address1 = new Address("Odisha1");
			cust.setAddress(address1);
			address1.setCustomer(cust);
			session.save(cust);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		System.out.println("successfully saved into database");
	}
}
