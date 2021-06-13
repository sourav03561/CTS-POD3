package com.cts.pmsm.service;

import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;


public interface EmployeeService {
	
	public MedicalRepresentative addMedicalRepresentative(MedicalRepresentative medicalRepresentative);
	
	public Pharmacy addPharmacy(Pharmacy pharmacy);

}
