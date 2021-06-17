package com.cts.pmsm.service;

import java.util.List;

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

	@Override
	public List<MedicalRepresentative> getMedicalRepresentatives() {
		List<MedicalRepresentative> list =representativeRepo.findAll();
		return list;
	}

	@Override
	public List<Pharmacy> getPharmacies() {
		List<Pharmacy> list=pharmacyRepo.findAll();
		return list;
	}

}
