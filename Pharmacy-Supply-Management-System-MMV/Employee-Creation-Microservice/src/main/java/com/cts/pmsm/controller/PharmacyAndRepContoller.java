package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
	@PostMapping("/medicalRepresentative")
	public ResponseEntity<ServiceResponse<MedicalRepresentative>> addRepresentative(@RequestBody MedicalRepresentative medicalRepresentative, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		
		return new ResponseHandlers<MedicalRepresentative>().defaultResponse(controllerService.createRep(medicalRepresentative, requestTokenHeader), "Representative Added", HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/pharmacy")
	public ResponseEntity<ServiceResponse<Pharmacy>> addPharmacy(@RequestBody Pharmacy pharmacy, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException {
		return new ResponseHandlers<Pharmacy>().defaultResponse(controllerService.addPharma(pharmacy, requestTokenHeader), "Pharmacy Added", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/pharmacy")
	public ResponseEntity<ServiceResponse<List<Pharmacy>>> getPharmacies(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		return new ResponseHandlers<List<Pharmacy>>().defaultResponse(controllerService.getAllPharmacies(requestTokenHeader), "Got all pharmacies", HttpStatus.OK);
	}

	@GetMapping("/medicalRepresentative")
	public ResponseEntity<ServiceResponse<List<MedicalRepresentative>>> getRepresentatives(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		return new ResponseHandlers<List<MedicalRepresentative>>().defaultResponse(controllerService.getAllRepresentatives(requestTokenHeader), "Got all pharmacies", HttpStatus.OK);
	}

	

}
