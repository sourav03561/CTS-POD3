package com.cts.pmsm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pharmacyName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public Pharmacy(int id, String pharmacyName) {
		super();
		this.id = id;
		this.pharmacyName = pharmacyName;
	}
	public Pharmacy() {
		super();
	}
	
	
}
