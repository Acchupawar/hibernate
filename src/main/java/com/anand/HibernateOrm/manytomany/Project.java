package com.anand.HibernateOrm.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project_manytomany")
public class Project {

	@Id
	@Column(name = "Project_ID")
	private int pId;

	@Column(name = "Project_Name")
	private String pName;

	@ManyToMany (mappedBy = "projects")
	private List<Emp> emps;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", pName=" + pName + ", emps=" + emps + "]";
	}

}
