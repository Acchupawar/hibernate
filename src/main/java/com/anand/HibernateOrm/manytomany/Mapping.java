package com.anand.HibernateOrm.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		/**
		 * create a object of Emp class
		 */
		Emp emp1 = new Emp();
		emp1.seteId(104);
		emp1.seteName("Vihan");

		Emp emp2 = new Emp();
		emp2.seteId(105);
		emp2.seteName("Anand");

		/**
		 * create a object of Project Class
		 */
		Project project1 = new Project();
		project1.setpId(204);
		project1.setpName("team Management System ");

		Project project2 = new Project();
		project2.setpId(205);
		project2.setpName("Empalye Management System ");

		/**
		 * list of Emp class
		 */

		List<Emp> list1 = new ArrayList<Emp>();
		list1.add(emp1);
		list1.add(emp2);

		/*
		 * list of project class
		 */
		List<Project> list2 = new ArrayList<Project>();
		list2.add(project1);
		list2.add(project2);

		/*
		 * Many to Many
		 */
		
		emp1.setProjects(list2);
		emp2.setProjects(list2);
		
		project1.setEmps(list1);
		project2.setEmps(list1);
		
		/*
		 * Sessionn Open 
		 */
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(project1);
		session.save(project2);
		
		
		transaction.commit();
		session.close();
		
	}

}
