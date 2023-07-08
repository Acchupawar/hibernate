package com.anand.HibernateOrm.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * one to many Relationship mapping 
 * List of Object
 * @author DELL
 *
 */
@Entity
@Table(name= "question_one")
public class Question1 {

	@Id
	@Column(name = "question_id")
	private int id;
	
	private String question;
	
	@OneToMany(mappedBy = "question1")
	private List<Answer1> answer1;

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<Answer1> getAnswer1() {
		return answer1;
	}


	public void setAnswer1(List<Answer1> answer1) {
		this.answer1 = answer1;
	}


	@Override
	public String toString() {
		return "Question1 [id=" + id + ", question=" + question + ", answer1=" + answer1 + "]";
	}
	
	
	
}
