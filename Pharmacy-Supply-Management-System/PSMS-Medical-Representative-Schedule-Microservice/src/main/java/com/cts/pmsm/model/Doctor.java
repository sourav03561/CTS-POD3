package com.cts.pmsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private String contactNumber;
	private String treatingAilment;
	private String preferredSlot;
	
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
	public String getTreatingAilment() {
		return treatingAilment;
	}
	public void setTreatingAilment(String treatingAilment) {
		this.treatingAilment = treatingAilment;
	}
	
	public String getPreferredSlot() {
		return preferredSlot;
	}
	public void setPreferredSlot(String preferredSlot) {
		this.preferredSlot = preferredSlot;
	}
	
	public Doctor(int id, String name, String contactNumber, String treatingAilment, String preferredSlot) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.treatingAilment = treatingAilment;
		this.preferredSlot = preferredSlot;
	}
	public Doctor() {
		super();
	}
}
