package com.cts.pmsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.service.EmployeeService;

@RestController
public class PharmacyAndRepContoller {
	
	@Autowired
	EmployeeService emp;
	
	@PostMapping("/addRepresentative")
	public ResponseEntity<MedicalRepresentative> addRepresentative(@RequestBody MedicalRepresentative medicalRepresentative) {
		MedicalRepresentative medRep=emp.addMedicalRepresentative(medicalRepresentative);
		return new ResponseEntity<MedicalRepresentative>(medRep,HttpStatus.OK);
	}

}
