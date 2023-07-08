package com.anand.HibernateOrm.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Many to One Mapping Relationship 
 * here one question many answer have 
 * @author DELL
 *
 */
@Entity
@Table(name = "answer_many")
public class Answer1 {

	@Id
	@Column(name = "answer_id")
	private int id;

	private String answer;
	
	@ManyToOne
	private Question1 question1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

	public Question1 getQuestion1() {
		return question1;
	}

	public void setQuestion1(Question1 question1) {
		this.question1 = question1;
	}

	@Override
	public String toString() {
		return "Answer1 [id=" + id + ", answer=" + answer + ", question1=" + question1 + "]";
	}

	

}
