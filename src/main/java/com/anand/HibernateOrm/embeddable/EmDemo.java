package com.anand.HibernateOrm.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @embeddable anatation use 
 *
 */
public class EmDemo {

	public static void main(String[] args) {

		/**
		 * configuration of ORM
		 */
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		/**
		 * create object of Students Class 
		 */
		Students students = new Students();
		students.setName("Lokesh");
		students.setCity("Bangalore");
		/**
		 * create certicate object
		 */
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("8 Months");
		
		students.setCertificate(certificate);
		
		
		/**
		 * create object of Students Class 
		 */
		Students students1 = new Students();
		students1.setName("Anand");
		students1.setCity("Bider");
		/**
		 * create certicate object
		 */
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Python");
		certificate1.setDuration("6 Months");
		
		students1.setCertificate(certificate1);
		
		/**
		 * save this given information in dataase object save
		 */
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		/**
		 * save objetc 
		 */
		session.save(students);
		session.save(students1);
		
		transaction.commit();
		session.close();
		factory.close();
		
	}

}
