package com.anand.HibernateOrm.states;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collage_info")
public class Collage {

	@Id
	private int id;

	@Column(name = "Collage_Name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Collage [id=" + id + ", name=" + name + "]";
	}

}
