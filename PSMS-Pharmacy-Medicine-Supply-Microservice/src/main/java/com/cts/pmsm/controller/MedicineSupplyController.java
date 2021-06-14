package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;
import com.cts.pmsm.service.PharmacySupplyService;

@RestController
public class MedicineSupplyController {
	
	@Autowired
	PharmacySupplyService pss;
	

	@GetMapping("/healthCheck")
	public String healthCheck(){
		
		return "ok";
		
	}
	
	@PostMapping("/pharmacySupply")
	public List<PharmacyMedicineSupply> getPharmacySupply(@RequestBody List<MedicineDemand> medicineDemand){
			return pss.getPharmacySupplyFromService(medicineDemand);
		
	}
}
