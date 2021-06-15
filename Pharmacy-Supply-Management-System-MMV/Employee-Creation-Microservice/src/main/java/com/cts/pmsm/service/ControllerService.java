package com.cts.pmsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;

@Service
public class ControllerService {

	
	@Autowired
	EmployeeService emp;
	
	@Autowired
	AuthorizationClient authorizationClient;
	
	
	public MedicalRepresentative createRep(MedicalRepresentative medicalRepresentative,
			String requestTokenHeader) throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicalRepresentative medRep=emp.addMedicalRepresentative(medicalRepresentative);
			return medRep;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	public Pharmacy addPharma(Pharmacy pharmacy, String requestTokenHeader) throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			Pharmacy p=emp.addPharmacy(pharmacy);
			return p;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
}
