package com.cubic.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")

public class CustomerEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "cSeq", sequenceName = "CUSTOMER_SEQ")
	@GeneratedValue(generator = "cSeq")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFristName() {
		return firstName;
	}

	public void setFristName(String fristName) {
		this.firstName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
