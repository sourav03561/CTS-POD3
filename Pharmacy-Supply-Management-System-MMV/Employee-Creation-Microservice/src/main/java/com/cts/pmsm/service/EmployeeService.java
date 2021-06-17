package com.cts.pmsm.service;

import java.util.List;

import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;


public interface EmployeeService {
	
	public MedicalRepresentative addMedicalRepresentative(MedicalRepresentative medicalRepresentative);
	
	public List<MedicalRepresentative> getMedicalRepresentatives();
	
	public Pharmacy addPharmacy(Pharmacy pharmacy);
	
	public List<Pharmacy> getPharmacies();

}
