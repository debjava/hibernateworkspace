package com.ddlab.rnd.onetomany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void showUser(Session session, String name) {
		try {
//			String hql = "FROM ZaraUser";
			String hql = "FROM ZaraUser za where za.userName = "+"\'"+name+"\'";
			Query query = session.createQuery(hql);
			List results = query.list();
			for( int i = 0 ; i < results.size() ; i++) {
				ZaraUser user = (ZaraUser) results.get(i);
				System.out.println("User :::"+user);
				
				Set<ZaraUserDetails> userDetailsList = user.getZaraUserDetails();
				for( ZaraUserDetails userDetail : userDetailsList ) {
					
					System.out.println("User Details :::"+userDetail);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
    	SessionFactory sessionFactory = (SessionFactory)context.getBean("hibSessionFactory");
    	Session session = sessionFactory.openSession();
    	showUser(session,"piku");
    	
//    	ZaraUser user = new ZaraUser();
//    	user.setAccountNonExpired(true);
//    	user.setAccountNonLocked(true);
//    	user.setCredentialsNonExpired(true);
//    	user.setEnabled(true);
//    	user.setPassword("deba");
//    	user.setUserName("deba");
//    	
//    	
//    	ZaraUserDetails userDetails1 = new ZaraUserDetails("deba","ROLE_ADMIN", user);
//    	ZaraUserDetails userDetails2 = new ZaraUserDetails("deba","ROLE_ADMIN", user);
//    	
//    	
//    	Set<ZaraUserDetails> userDetailsList = new HashSet<ZaraUserDetails>();
//    	userDetailsList.add(userDetails1); 
//    	userDetailsList.add(userDetails2); 
//    	
//    	
//    	user.setZaraUserDetails(userDetailsList);
//    	Transaction tx = null;
//    	try {
//    		tx = session.beginTransaction();
//    		session.save(user);
//    		tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	finally{
//            if(!sessionFactory.isClosed()) {
//                System.out.println("Closing SessionFactory");
//                sessionFactory.close();
//            }
//        }
    	
    }
}
