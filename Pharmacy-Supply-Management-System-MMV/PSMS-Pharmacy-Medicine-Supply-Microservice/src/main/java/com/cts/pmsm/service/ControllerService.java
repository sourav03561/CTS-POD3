package com.cts.pmsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;

@Service
public class ControllerService {

	
	@Autowired
	AuthorizationClient authorizationClient;
	
	@Autowired
	PharmacySupplyService pss;
	
	
	public List<PharmacyMedicineSupply> getSupply(List<MedicineDemand> medicineDemand, String requestTokenHeader)
			throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			return pss.getPharmacySupplyFromService(medicineDemand, requestTokenHeader);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	
	public List<MedicineDemand> getDemand(String requestTokenHeader) throws AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			return pss.getAllDemand(requestTokenHeader);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	public List<PharmacyMedicineSupply> getSupplies(String requestTokenHeader) throws AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			return pss.getAllSupply(requestTokenHeader);
		
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
}
