package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.model.ServiceResponse;


@FeignClient(name="MEDICINE-STOCK-MICROSERVICE")
public interface MedicineStockClient {

	@GetMapping("/stock")
	public ResponseEntity<ServiceResponse<List<MedicineStock>>> getStockInformation(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
}
