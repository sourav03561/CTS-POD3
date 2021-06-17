package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.ServiceResponse;

@FeignClient("EMPLOYEE-MICROSERVICE")
public interface EmployeeClient {
	
	@GetMapping("/medicalRepresentative")
	public ResponseEntity<ServiceResponse<List<MedicalRepresentative>>> getRepresentatives(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;

}
