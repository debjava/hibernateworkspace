package com.ddlab.rnd.orm.bidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Check for Bi-directional
//http://viralpatel.net/blogs/hibernate-one-to-many-annotation-tutorial/
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
    	SessionFactory sessionFactory = (SessionFactory)context.getBean("hibSessionFactory");
    	Session session = sessionFactory.openSession();
    	
    	BankCustomer customer1 = new BankCustomer();
    	customer1.setName("Satya");
    	
    	
    	BankAccount account1 = new BankAccount("USD", "311111");
    	BankAccount account2 = new BankAccount("AUD", "322222");
    	
    	Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
    	bankAccounts.add(account1); 
    	bankAccounts.add(account2); 
    	
    	customer1.setAccounts(bankAccounts);
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(customer1);
    		
//    		session.save(account1);
//            session.save(account2);
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
    }
}
