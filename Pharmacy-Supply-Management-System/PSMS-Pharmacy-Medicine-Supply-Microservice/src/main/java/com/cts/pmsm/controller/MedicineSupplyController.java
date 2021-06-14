package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;
import com.cts.pmsm.service.PharmacySupplyService;

@RestController
public class MedicineSupplyController {
	
	@Autowired
	PharmacySupplyService pss;
	
	@Autowired
	AuthorizationClient authorizationClient;

	@GetMapping("/healthCheck")
	public String healthCheck(){
		
		return "ok";
		
	}
	
	@PostMapping("/pharmacySupply")
	public List<PharmacyMedicineSupply> getPharmacySupply(@RequestBody List<MedicineDemand> medicineDemand, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			return pss.getPharmacySupplyFromService(medicineDemand, requestTokenHeader);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
	}
}
