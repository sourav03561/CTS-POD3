package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;
import com.cts.pmsm.model.ServiceResponse;

@FeignClient("PHARMACY-MEDICINE-SUPPLY-MICROSERVICE")
public interface MedicineSupplyClient {

	@PostMapping("/pharmacySupply")
	public ResponseEntity<ServiceResponse<List<PharmacyMedicineSupply>>> getPharmacySupply(@RequestBody List<MedicineDemand> medicineDemand, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
}
