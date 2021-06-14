package com.cts.pmsm.model;

public class MedicineDemand {

	private String medicineName;
	private int demandCount;
	
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getDemandCount() {
		return demandCount;
	}
	public void setDemandCount(int demandCount) {
		this.demandCount = demandCount;
	}
	public MedicineDemand(String medicineName, int demandCount) {
		super();
		this.medicineName = medicineName;
		this.demandCount = demandCount;
	}
	public MedicineDemand() {
		super();
	}
}
