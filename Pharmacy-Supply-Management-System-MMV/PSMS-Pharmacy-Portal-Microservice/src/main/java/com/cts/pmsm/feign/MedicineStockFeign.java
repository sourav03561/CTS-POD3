package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.MedicineStock;

@FeignClient("MEDICINE-STOCK-MICROSERVICE")
public interface MedicineStockFeign {
	

		@GetMapping("/medicineStockInformation")
		public List<MedicineStock> getStockInformation(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
		
		@PostMapping("/createMedicineStock")
		public ResponseEntity<?> createMedicineStock(@RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
		
		@DeleteMapping("/deleteStock/{id}")
		public ResponseEntity<?> deleteStockById(@PathVariable int id,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;
		
		@PutMapping("/updateStock/{id}")
		public ResponseEntity<MedicineStock> updateStockById(@PathVariable int id, @RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws MedicineStockNotFoundException, AuthorizationException;
}


