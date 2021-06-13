package com.cts.pmsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.MedicalRepresentativeRepo;
import com.cts.pmsm.dao.PharmacyRepo;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	MedicalRepresentativeRepo representativeRepo;
	
	@Autowired
	PharmacyRepo pharmacyRepo;

	@Override
	public MedicalRepresentative addMedicalRepresentative(MedicalRepresentative medicalRepresentative) {
		
		return representativeRepo.save(medicalRepresentative);
	}

	@Override
	public Pharmacy addPharmacy(Pharmacy pharmacy) {
		
		return pharmacyRepo.save(pharmacy);
	}

}
