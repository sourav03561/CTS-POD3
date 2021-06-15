package com.cts.pmsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.handler.ResponseHandlers;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;
import com.cts.pmsm.model.ServiceResponse;
import com.cts.pmsm.service.ControllerService;

@RestController
public class PharmacyAndRepContoller {
	
	
	@Autowired
	ControllerService controllerService;
	
	
	
	@PostMapping("/addRepresentative")
	public ResponseEntity<ServiceResponse<MedicalRepresentative>> addRepresentative(@RequestBody MedicalRepresentative medicalRepresentative, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		
		return new ResponseHandlers<MedicalRepresentative>().defaultResponse(controllerService.createRep(medicalRepresentative, requestTokenHeader), "Representative Added", HttpStatus.CREATED);
		
		
	}

	
	
	@PostMapping("/addPharmacy")
	public ResponseEntity<ServiceResponse<Pharmacy>> addPharmacy(@RequestBody Pharmacy pharmacy, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		return new ResponseHandlers<Pharmacy>().defaultResponse(controllerService.addPharma(pharmacy, requestTokenHeader), "Pharmacy Added", HttpStatus.CREATED);
		
	}



	

}
