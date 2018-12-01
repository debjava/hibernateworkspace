package com.ddlab.rnd.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Many to One
 */
public class Test1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Book> booksSet = new HashSet<Book>();
			Book book1 = new Book();
			book1.setBookName("Horror");
			booksSet.add(book1);

			Book book2 = new Book();
			book2.setBookName("Novel");
			booksSet.add(book2);

			Author author1 = new Author();
			author1.setAuthorName("Deb");
			author1.setBooks(booksSet);

			book1.getAuthors().add(author1);

			// session.save(author1);
			// OR
			session.save(book1);

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
