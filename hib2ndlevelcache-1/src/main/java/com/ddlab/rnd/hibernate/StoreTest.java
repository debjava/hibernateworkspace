package com.ddlab.rnd.hibernate;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

public class StoreTest {

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();

		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);

		return factory;
	}

	public static void main(String[] args) {

		try {

			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();

			Transaction tx = session.beginTransaction();

			session.save(new Employee("Deb", 50000));
			session.save(new Employee("Mishra", 70000));

			tx.commit();

			session.close();

			factory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
