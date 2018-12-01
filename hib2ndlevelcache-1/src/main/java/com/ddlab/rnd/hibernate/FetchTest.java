package com.ddlab.rnd.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FetchTest {

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();

		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);

		return factory;
	}

	public static void main(String[] args) {

		SessionFactory factory = getSessionFactory();
		Session session1 = factory.openSession();
		int rowNo = 2;
		Employee emp1 = (Employee) session1.load(Employee.class, rowNo);

		System.out.println(emp1.getId() + " " + emp1.getName() + " " + emp1.getSalary());
		session1.close();

		Session session2 = factory.openSession();
		Employee emp2 = (Employee) session2.load(Employee.class, rowNo);
		System.out.println(emp2.getId() + " " + emp2.getName() + " " + emp2.getSalary());
		session2.close();

		factory.close();

	}
}
