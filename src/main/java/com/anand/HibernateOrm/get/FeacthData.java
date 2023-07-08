package com.anand.HibernateOrm.get;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anand.HibernateOrm.Address;
import com.anand.HibernateOrm.Hotel;
import com.anand.HibernateOrm.Student;
/**
 * Fetch the data from database this application
 * @author DELL
 *
 */
public class FeacthData {

	public static void main(String[] args) {

		/**
		 * session configuration to fetch the data from database
		 */
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		/**
		 * get() method return null value if data is not available 
		 * get method work on cache store memory 
		 * get method first check in our cache store if it is available gives return a value if not available then goes to data base and provide a value 
		 * if we are not sure that object exists in DB or not its give a null value if object are not available 
		 */ 
		Student student = session.get(Student.class, 101);
		Address address = session.get(Address.class, 1);
		/**
		 * load() method return throw exception not fond object 
		 * load method lazy inisalizar becouse it not fire a quiry its gives a object 
		 * when we use that object then fire the quiry to database and get the details 
		 * load method we will uss if we are sure the exist object in database
		 */
		Hotel hotel = session.load(Hotel.class, 101);
		 
		System.out.println(student);
		System.out.println(address);
		System.out.println(hotel);

	}

}
