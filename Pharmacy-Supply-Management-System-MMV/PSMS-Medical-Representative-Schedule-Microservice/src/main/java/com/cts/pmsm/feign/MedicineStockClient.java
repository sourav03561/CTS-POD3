package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicineStock;


@FeignClient(name="MEDICINE-STOCK-MICROSERVICE")
public interface MedicineStockClient {

	@GetMapping("/medicineStockInformation")
	public List<MedicineStock> getStockInformation(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
}
