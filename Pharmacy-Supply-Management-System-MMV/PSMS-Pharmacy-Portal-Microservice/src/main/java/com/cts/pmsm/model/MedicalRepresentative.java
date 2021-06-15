package com.cts.pmsm.model;

public class MedicalRepresentative {
	private int id;
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
	public MedicalRepresentative(int id, String name, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
	}
	public MedicalRepresentative() {
		super();
	}
}