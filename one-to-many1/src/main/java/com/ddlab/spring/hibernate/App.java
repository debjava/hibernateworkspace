package com.ddlab.spring.hibernate;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * One to many
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
    	SessionFactory sessionFactory = (SessionFactory)context.getBean("hibSessionFactory");
    	Session session = sessionFactory.openSession();
    	System.out.println(session);
    	
    	Cart1 cart = new Cart1();
        cart.setName("MyCart1");
         
        Items1 item1 = new Items1("I10", 10, 1, cart);
        Items1 item2 = new Items1("I20", 20, 2, cart);
        Set<Items1> itemsSet = new HashSet<Items1>();
        itemsSet.add(item1); 
        itemsSet.add(item2);
         
        cart.setItems1(itemsSet);
        cart.setTotal(10*1 + 20*2);
         
        Transaction tx = null;
        try{
        System.out.println("Session created");
        //start transaction
        tx = session.beginTransaction();
        //Save the Model object
        session.save(cart);
        session.save(item1);
        session.save(item2);
        //Commit transaction
        tx.commit();
        System.out.println("Cart1 ID="+cart.getId());
        System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
        System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
         
        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }finally{
            if(!sessionFactory.isClosed()) {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }
}
