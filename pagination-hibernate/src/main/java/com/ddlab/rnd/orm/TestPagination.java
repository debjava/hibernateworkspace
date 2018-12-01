package com.ddlab.rnd.orm;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPagination {
	
	public static void showAnimalsPageByPage(int minValue ) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		System.out.println("Initial Value :::"+minValue);
		Query query = session.createQuery("From Animal");
		query.setFirstResult(minValue);
		query.setMaxResults(10);
		List<Animal> animalList = query.list();
		for( Animal animal : animalList ) {
			System.out.println("Animal Name :::"+animal.getName());
		}
	}
	
	public static void showAnimals(Session session, int minValue ) {
		System.out.println("Initial Value :::"+minValue);
		Query query = session.createQuery("From Animal");
		query.setFirstResult(minValue);
		query.setMaxResults(10);
		List<Animal> animalList = query.list();
		for( Animal animal : animalList ) {
			System.out.println("Animal Name :::"+animal.getName());
		}
	}
	
	//The Total Count and the Last Page
	public static void getAllAnimals() {
		int pageSize = 10;
	    String countQ = "Select count(a.id) from Animal a";
	    Session session = getSession();
	    Query countQuery = session.createQuery(countQ);
	    Long countResults = (Long) countQuery.uniqueResult();
	    System.out.println("countResults---->"+countResults);//100
	    int lastPageNumber = (int) ((countResults / pageSize) + 1);
	    System.out.println("lastPageNumber :::"+lastPageNumber);//11
	 
	    Query selectQuery = session.createQuery("From Animal");
	    int initialPage = (lastPageNumber - 1) * pageSize;
	    System.out.println("Initial Page :::"+initialPage);//100
	    selectQuery.setFirstResult((lastPageNumber - 1) * pageSize);
	    selectQuery.setMaxResults(pageSize);
	    List<Animal> lastPage = selectQuery.list();
	}
	
	/*
	 * Using ScrollableResults to implement pagination has the potential to reduce database calls. 
	 * This approach streams the result set as the program scrolls though it, 
	 * therefore eliminating the need to repeat the query to fill each page:
	 */
	public static void getAllAnimalsByScrollableResults() {
		Session session = getSession();
		String hql = "FROM Animal";
		Query query = session.createQuery(hql);
		int pageSize = 10;
		ScrollableResults resultScroll = query.scroll(ScrollMode.FORWARD_ONLY);
		resultScroll.first();
		resultScroll.scroll(0);//You can increase like 10, 20 ,30
		int i = 0;
		while (pageSize > i++) {
			Animal animal = (Animal) resultScroll.get(0);
			System.out.println("Animal Name :::"+animal.getName());
		    if (!resultScroll.next())
		        break;
		}
	}
	
	public static void getAllAnimalsByCriteria() {
		Session session = getSession();
		int pageSize = 10;
		String hql = "FROM Animal";
		Criteria criteria = session.createCriteria(Animal.class);
		criteria.setFirstResult(0);//You can set like 10,20,30
		criteria.setMaxResults(pageSize);
		List<Animal> firstPage = criteria.list();
		for(Animal animal : firstPage) {
			System.out.println("Animal Name :::"+animal.getName());
		}
	}
	
	public static Session getSession() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void main(String[] args) {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"app-context.xml");
//		SessionFactory sessionFactory = (SessionFactory) context
//				.getBean("hibSessionFactory");
//		Session session = sessionFactory.openSession();
		
//		for( int i = 0 ; i < 100 ; i = i+10) {
//			int minValue = i;
////			showAnimals(session, minValue);
//			showAnimalsPageByPage(minValue);
//			System.out.println("============================================");
//		}
		
//		getAllAnimals();
//		getAllAnimalsByScrollableResults();
		getAllAnimalsByCriteria();
	}

}
