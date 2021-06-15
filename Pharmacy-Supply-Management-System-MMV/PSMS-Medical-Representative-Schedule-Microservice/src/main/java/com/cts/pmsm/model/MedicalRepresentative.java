package com.cts.pmsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRepresentative {
	@Id
	private int id;
	private String name;
	private String contactNumber;
	
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public MedicalRepresentative(int id, String name, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
	}
	public MedicalRepresentative() {
		super();
	}
}
