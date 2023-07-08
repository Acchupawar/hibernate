package com.anand.HibernateOrm.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class States {

	public static void main(String[] args) {

		/*
		 * Configuration with the session
		 */
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		/*
		 * creating a object of Entity class called Collage
		 */
		Collage collage = new Collage();
		collage.setId(101);
		collage.setName("JSPIDER");
		/*
		 * now hibernate comes in Transient State	Hibernate state 
		 * Once a object will create and Value are set 	comes into Trasient state
		 */
		
		/*
		 * session open here 
		 */
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(collage);
		/*
		 * Once we called a Save() method from session interface
		 * And pass the object of Collage class inside save method 
		 * Hibernate comes into Persistent State 
		 * Value will be store into DataBadse and Associte with object and DataBase here
		 */
		
		transaction.commit();
		
		session.close();
		/*
		 * Once Session will be closed 
		 * Hibernate comes into Detached State and here Not to be Associte with the Databse and Object  
		 */
		
		Collage collage2 = session.get(Collage.class, 101);
		/*
		 * If we are doing like delet, getData , removeData, FeatchData etc 
		 * Hibernate come into a state Removed State here Associte with the Object and DataBase 
		 */
		System.out.println(collage2);
		
		factory.close();
	}

}
