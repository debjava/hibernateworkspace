package com.ddlab.rnd.orm;

import java.util.List;

import net.sf.ehcache.CacheManager;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void bulkInsert(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for ( int i=0; i<3000; i++ ) {
				Employee employee = new Employee("Name-"+i, "City-"+i);
				session.save(employee);
				//Otherwise it will throw OutOfMemory Error
				if( i % 1000 == 0 ) { 
					//flush a batch of inserts and release memory:
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
			ScrollableResults empResults = session.createQuery("FROM Employee").scroll();
			int count = 0;
			while ( empResults.next() ) {
				Employee employee = (Employee) empResults.get(0);
				employee.setCity("My City-"+count);
				count++;
				session.update(employee);
				//Otherwise it will throw OutOfMemory Error
				if( count % 1000 == 0 ) { 
					//flush a batch of inserts and release memory:
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

	public static void showQueryResult(Session session) {
		Query query = session.createQuery("from Employee e  where e.empId > :empId").setCacheable(true);
		query.setCacheRegion("myemployee");
		query.setInteger("empId", 2000);
		List<Employee> empList = (List<Employee>) query.list();
		//	     query.uniqueResult();
		System.out.println("Employee List Size :::"+empList.size());
			    for(Employee emp : empList) {
			    	System.out.println(emp.getEmpId()+"---"+emp.getFirstName()+"---"+emp.getCity());
			    }
	}

	public static void printStatistics(SessionFactory sessionFactory) {
		Statistics stat = sessionFactory.getStatistics();
//		sessionFactory.getStatistics().logSummary();
		String regions[] = stat.getSecondLevelCacheRegionNames();
		System.out.println("regions----->"+regions.toString());
		for(String regionName:regions) {
			SecondLevelCacheStatistics stat2 = stat.getSecondLevelCacheStatistics(regionName);
			System.out.println("2nd Level Cache(" +regionName+") Put Count: "+stat2.getPutCount());
			System.out.println("2nd Level Cache(" +regionName+") HIt Count: "+stat2.getHitCount());
			System.out.println("2nd Level Cache(" +regionName+") Miss Count: "+stat2.getMissCount());
			System.out.println("2nd Level Cache stat2.getElementCountInMemory() : "+stat2.getElementCountInMemory());
			System.out.println("2nd Level Cache getElementCountOnDisk() : "+stat2.getElementCountOnDisk());
		}
	}

	public static void main( String[] args )
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();

		//		bulkInsert(session);
		//		bulkUpdate(session);

		showQueryResult(session);
		System.out.println("=========================");
		showQueryResult(session);
		
		List<CacheManager> tempManagers = CacheManager.ALL_CACHE_MANAGERS;
		System.out.println("# of CMs : " + tempManagers.size());
		for (CacheManager tempCM : tempManagers) {
		        System.out.println("Got: " + tempCM.getName());
		        String[] cacheNames = tempCM.getCacheNames();
		        for (int i = 0; i < cacheNames.length; i++) {
		            String cacheName = cacheNames[i];
		            System.out.println(cacheName+" - "+ tempCM.getEhcache(cacheName).getStatistics().toString());
		        }
		}
		System.out.println("=========================");
		printStatistics(sessionFactory);

		session.flush();
		session.clear();
		session.close();
	}
}
