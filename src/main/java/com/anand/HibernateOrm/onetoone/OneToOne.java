package com.anand.HibernateOrm.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {

		/**
		 * configaration of ORM
		 */
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		/**
		 * create question object 1
		 */
		Question question = new Question();
		question.setQuestion("what is java ?");
	
		
		/**
		 * creattin object of Anser class
		 */
		Answer answer = new Answer();
		answer.setAnswer("java is programing langauge");
		
		/**
		 * one to one 
		 */
		question.setAnswer(answer);
		
		/**
		 * create question object 2
		 */
		Question question1 = new Question();
		question1.setQuestion("what is python ?");
	
		
		/**
		 * creattin object of Anser class
		 */
		Answer answer1 = new Answer();
		answer1.setAnswer("python is programing langauge");
		
		/**
		 * one to one 
		 */
		question1.setAnswer(answer1);
		
		/**
		 * save this information in database 
		 * session configuration
		 */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);
		
		transaction.commit();
		/** 
		 * fecth data from database 
		 */
		Question question2 = session.get(Question.class, 1);
		System.out.println(question2.getQuestion());
		System.out.println(question2.getAnswer());
		
		
		session.close();

		
		
	}

}
