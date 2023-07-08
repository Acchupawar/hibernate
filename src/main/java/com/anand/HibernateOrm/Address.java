package com.anand.HibernateOrm;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity // use to mark any class as Entity
@Table(name = "student_address") // use to change the table name or details
public class Address {

	@Id // use to make a primary key
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto") // id auto garnered
	@Column(name="address_id") // can be use to specify column name to mapping or change the column name or set a length of attribute 
	private int id; // field of class 
	
	@Column(length = 50,name="STREET")
	private String street;
	
	@Column(length = 100) // set the length of attribute 
	private String city;
	
	@Column(name="is_Open")
	private boolean isOpen;
	
	@Transient // not to be added this column in table 
	private double x;
	
	@Column(name="added_date")
	@Temporal(TemporalType.DATE) // to use date format in a table 
	private Date date;
	
	@Lob // large object 
	private byte[] image;

	/**
	 * 
	 * Getter and setter function
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * to string method 
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x=" + x
				+ ", date=" + date + ", image=" + Arrays.toString(image) + "]";
	}

}
