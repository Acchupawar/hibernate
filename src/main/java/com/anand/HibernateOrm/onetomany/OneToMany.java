package com.anand.HibernateOrm.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		/**
		 * create object of Question class one question
		 */
		Question1 question1 = new Question1();
		question1.setId(102);
		question1.setQuestion("what is java ?");

		/**
		 * create object of Answe class Many answer List of answer
		 */

		Answer1 answer1 = new Answer1();
		answer1.setId(106);
		answer1.setAnswer("java is an programing language ");
		answer1.setQuestion1(question1);

		Answer1 answer2 = new Answer1();
		answer2.setId(107);
		answer2.setAnswer("java is an Platform Indipendent language");
		answer2.setQuestion1(question1);

		Answer1 answer3 = new Answer1();
		answer3.setId(108);
		answer3.setAnswer("java is obejct orient programing language");
		answer3.setQuestion1(question1);

		/**
		 * create a object of list Array
		 */

		List<Answer1> list = new ArrayList<Answer1>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);

		/**
		 * one Question have Many Answer
		 */
		question1.setAnswer1(list);
		
		/**
		 * session open
		 */
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

//		session.save(question1);
//		session.save(answer1);
//		session.save(answer2);
//		session.save(answer3);

		transaction.commit();

		/**
		 * featch data 
		 */
		Question1 quest = session.get(Question1.class, 101);
		System.out.println(quest.getQuestion());
		/**
		 * list of answer
		 */
		System.out.println(quest.getAnswer1());
		
		for( Answer1 a : quest.getAnswer1() )
		{
			System.out.println(a);
		}
			
		session.close();

	}

}
