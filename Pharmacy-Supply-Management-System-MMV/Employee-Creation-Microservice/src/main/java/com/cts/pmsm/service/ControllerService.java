package com.cts.pmsm.service;

import java.util.List;

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
	
	public List<MedicalRepresentative> getAllRepresentatives(String requestTokenHeader) throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			List<MedicalRepresentative> m=emp.getMedicalRepresentatives();
			return m;
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
	
	
	public List<Pharmacy> getAllPharmacies(String requestTokenHeader) throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			List<Pharmacy> p=emp.getPharmacies();
			return p;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
}
