package com.anand.HibernateOrm.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "emp_manytomany")
public class Emp {

	@Id
	@Column(name = "emp_id")
	private int eId;

	@Column(name = "emp_Name")
	private String eName;

	@ManyToMany
	private List<Project> projects;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + ", projects=" + projects + "]";
	}

}
