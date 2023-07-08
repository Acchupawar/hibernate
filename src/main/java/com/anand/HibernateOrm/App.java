package com.anand.HibernateOrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started..");

		/**
		 * orm configuration sessionFactory
		 */
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		// System.out.println(factory);

		/**
		 * creating student object
		 */
		Student student = new Student();
		student.setId(102);
		student.setName("loki");
		student.setCity("bangalore");
		System.out.println(student);

		/**
		 * create a hotel object
		 */
		Hotel hotel = new Hotel();
		hotel.setId(102);
		hotel.setName("Udupi");
		hotel.setLocation("mahadevapura");
		
		/**
		 * create a address object 
		 */
		
		Address address = new Address();
		address.setStreet("om shakti layout");
		address.setCity("bangalore");
		address.setOpen(true);
		address.setDate(new Date());
		address.setX(123.123);
		
		/**
		 * image reading insert inside a table 
		 */
		FileInputStream file = new FileInputStream("src/main/java/images.jpeg");
		byte[] img = new byte[file.available()];
		file.read(img);
		
		address.setImage(img);
		
		/**
		 * session configuration
		 */
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.save(hotel);
		session.save(address);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
