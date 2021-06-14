package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicineStock;

@FeignClient("MEDICINE-STOCK-MICROSERVICE")
public interface MedicineStockClient {

	@GetMapping("/medicineStockInformation")
	public List<MedicineStock> getStockInformation();
	
	@PostMapping("/updateStock/{medicineName}/{count}")
	public boolean updateNumberOfTabletsInStockByName(@PathVariable("medicineName") String medicine, @PathVariable("count") int count);
}
