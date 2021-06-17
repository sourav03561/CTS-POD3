package com.cts.pmsm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;
import com.cts.pmsm.model.ServiceResponse;

@FeignClient("EMPLOYEE-MICROSERVICE")
public interface AddEmployeeClient {
	
	@PostMapping("/medicalRepresentative")
	public ResponseEntity<ServiceResponse<MedicalRepresentative>> addRepresentative(@RequestBody MedicalRepresentative medicalRepresentative, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
	
	@PostMapping("/pharmacy")
	public ResponseEntity<ServiceResponse<Pharmacy>> addPharmacy(@RequestBody Pharmacy pharmacy, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;

}
