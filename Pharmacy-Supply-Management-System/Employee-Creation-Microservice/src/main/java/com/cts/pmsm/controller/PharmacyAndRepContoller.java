package com.cts.pmsm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;
import com.cts.pmsm.service.EmployeeService;

@RestController
public class PharmacyAndRepContoller {
	
	@Autowired
	EmployeeService emp;
	
	@Autowired
	AuthorizationClient authorizationClient;
	
	@PostMapping("/addRepresentative")
	public ResponseEntity<MedicalRepresentative> addRepresentative(@RequestBody MedicalRepresentative medicalRepresentative, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicalRepresentative medRep=emp.addMedicalRepresentative(medicalRepresentative);
			return new ResponseEntity<MedicalRepresentative>(medRep,HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
		
	}
	
	@PostMapping("/addPharmacy")
	public ResponseEntity<Pharmacy> addPharmacy(@RequestBody Pharmacy pharmacy, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			Pharmacy p=emp.addPharmacy(pharmacy);
			return new ResponseEntity<Pharmacy>(p,HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
	}

}
