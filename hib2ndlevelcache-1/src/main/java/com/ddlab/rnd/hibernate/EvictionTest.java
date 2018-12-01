package com.ddlab.rnd.hibernate;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;

public class EvictionTest {
	
	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();

		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);

		return factory;
	}
	
	/**
	 * Evicts all second level cache hibernate entites. This is generally only
	 * needed when an external application modifies the databaase.
	 */
	public static void evict2ndLevelCache( SessionFactory sessionFactory ) {
	    try {
	        Map<String, ClassMetadata> classesMetadata = sessionFactory.getAllClassMetadata();
	        for (String entityName : classesMetadata.keySet()) {
	        	System.out.println("Evicting Entity from 2nd level cache: " + entityName);
	            sessionFactory.evictEntity(entityName);
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {

		SessionFactory factory = getSessionFactory();
		Session session1 = factory.openSession();
		int rowNo = 2;
		Employee emp1 = (Employee) session1.load(Employee.class, rowNo);

		System.out.println(emp1.getId() + " " + emp1.getName() + " " + emp1.getSalary());
		session1.close();
		
		//If you evict the entity, the query will be fired once agains
		evict2ndLevelCache(factory);
		
		
//		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount());           //Prints 1
//		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());   //Prints 0
		

		Session session2 = factory.openSession();
		Employee emp2 = (Employee) session2.load(Employee.class, rowNo);
		System.out.println(emp2.getId() + " " + emp2.getName() + " " + emp2.getSalary());
		session2.close();

		factory.close();

	}

}
