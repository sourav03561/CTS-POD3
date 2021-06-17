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
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;
import com.cts.pmsm.model.ServiceResponse;
import com.cts.pmsm.service.ControllerService;

@RestController
public class MedicineSupplyController {
	
	@Autowired
	ControllerService controllerService;

	@GetMapping("/healthCheck")
	public String healthCheck(){
		
		return "ok";
		
	}
	
	@PostMapping("/pharmacySupply")
	public ResponseEntity<ServiceResponse<List<PharmacyMedicineSupply>>> getPharmacySupply(@RequestBody List<MedicineDemand> medicineDemand, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		return new ResponseHandlers<List<PharmacyMedicineSupply>>().defaultResponse(controllerService.getSupply(medicineDemand, requestTokenHeader), "Supply done", HttpStatus.OK);
		
	}
	
	@GetMapping("/demand")
	public ResponseEntity<ServiceResponse<List<MedicineDemand>>> getAllDemand(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		return new ResponseHandlers<List<MedicineDemand>>().defaultResponse(controllerService.getDemand(requestTokenHeader), "Got Demand", HttpStatus.OK);
	}
	
	@GetMapping("/supply")
	public ResponseEntity<ServiceResponse<List<PharmacyMedicineSupply>>> getAllSupply(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		return new ResponseHandlers<List<PharmacyMedicineSupply>>().defaultResponse(controllerService.getSupplies(requestTokenHeader), "Got Supply", HttpStatus.OK);
		
	}
	
}
