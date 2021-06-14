package com.cts.pmsm.model;

import java.time.LocalDate;

public class MedicineStock {
	private int id;
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	private LocalDate dateOfExpiry;
	private int numberOfTabletsInStock;
	
	
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
	public String getChemicalComposition() {
		return chemicalComposition;
	}
	public void setChemicalComposition(String chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}
	public String getTargetAilment() {
		return targetAilment;
	}
	public void setTargetAilment(String targetAilment) {
		this.targetAilment = targetAilment;
	}
	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public int getNumberOfTabletsInStock() {
		return numberOfTabletsInStock;
	}
	public void setNumberOfTabletsInStock(int numberOfTabletsInStock) {
		this.numberOfTabletsInStock = numberOfTabletsInStock;
	}
	public MedicineStock(int id, String name, String chemicalComposition, String targetAilment, LocalDate dateOfExpiry,
			int numberOfTabletsInStock) {
		super();
		this.id = id;
		this.name = name;
		this.chemicalComposition = chemicalComposition;
		this.targetAilment = targetAilment;
		this.dateOfExpiry = dateOfExpiry;
		this.numberOfTabletsInStock = numberOfTabletsInStock;
	}
	public MedicineStock() {
		super();
	}
	
}
