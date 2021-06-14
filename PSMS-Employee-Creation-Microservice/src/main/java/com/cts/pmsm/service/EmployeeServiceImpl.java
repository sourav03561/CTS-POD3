package com.cts.pmsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.MedicalRepresentativeRepo;
import com.cts.pmsm.model.MedicalRepresentative;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	MedicalRepresentativeRepo representativeRepo;

	@Override
	public MedicalRepresentative addMedicalRepresentative(MedicalRepresentative medicalRepresentative) {
		
		return representativeRepo.save(medicalRepresentative);
	}


}
