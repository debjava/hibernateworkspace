package com.ddlab.rnd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void store(Person person) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
	}
	
	public int getPersonList() {
		int personList = 0;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			personList = session.createQuery("from Person").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return personList;
	}

}
