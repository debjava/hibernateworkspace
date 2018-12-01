package com.ddlab.rnd.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	
	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void init() {
		new UserTest().doSetup();
	}
	
	public void doSetup() {
		context = new ClassPathXmlApplicationContext("test-dao.xml");
	}
	
	@Test
	public void testCreateUser() {
		ZaraUser user = createUser();
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
    	Session session = sessionFactory.openSession();
    	
    	
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(user);
    		tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally{
            if(!sessionFactory.isClosed()) {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//		createPerson("Deb");
//		Person p1 = userDAO.getPersonById(1);
//		assertEquals(1,p1.getId());
	}
	
	private ZaraUser createUser() {
		ZaraUser user = new ZaraUser();
		user.setUserId(1);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
//		user.setId(1);
		user.setPassword("Deb");
		user.setUserName("Deb");
		
		ZaraUserDetails userdetailsEntity = new ZaraUserDetails("Deb", "ROLE_ADMIN", user);
		Set<ZaraUserDetails> userDetailsList = new HashSet<ZaraUserDetails>();
		userDetailsList.add(userdetailsEntity);
		user.setZaraUserDetails(userDetailsList);
		
		return user;
	}

}
