package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.handler.ResponseHandlers;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.model.ServiceResponse;
import com.cts.pmsm.service.ControllerService;

@RestController
public class MedicineStockController {
	
	
	@Autowired
	ControllerService controllerService;
	
	
	
	@GetMapping("/healthCheck")
	public String health() {
		return "working";
	}
	
	
	@GetMapping("/stock")
	public ResponseEntity<ServiceResponse<List<MedicineStock>>> getStockInformation(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		return new ResponseHandlers<List<MedicineStock>>().defaultResponse(controllerService.showStock(requestTokenHeader), "Got All Stocks", HttpStatus.OK);
		
	}


	
	
	@PutMapping("/stock/{medicineName}/{count}")
	public ResponseEntity<ServiceResponse<Boolean>> updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String requestTokenHeader, @PathVariable("medicineName") String medicine, @PathVariable("count") int count) throws AuthorizationException {
		
		return new ResponseHandlers<Boolean>().defaultResponse(controllerService.updateCountByName(requestTokenHeader, medicine, count), "Updated Stock By Name", HttpStatus.OK);
		
	}


	
	
	//=====================================================================
	
	
	@PostMapping("/stock")
	public ResponseEntity<ServiceResponse<MedicineStock>> createMedicineStock(@RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		return new ResponseHandlers<MedicineStock>().defaultResponse(controllerService.create(medicineStock, requestTokenHeader), "New Stock Created", HttpStatus.CREATED);
		
	}


	

	@GetMapping("/stock/{id}")
	public ResponseEntity<ServiceResponse<MedicineStock>> getStockById(@PathVariable int id,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws MedicineStockNotFoundException, AuthorizationException{
		
		return new ResponseHandlers<MedicineStock>().defaultResponse(controllerService.getByID(id, requestTokenHeader), "Got Stock", HttpStatus.OK);
		
	}


	
	
	@DeleteMapping("/stock/{id}")
	public ResponseEntity<ServiceResponse<?>> deleteStockById(@PathVariable int id,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{

		controllerService.deleteById(id, requestTokenHeader);
		return new ResponseHandlers<>().defaultResponse("Stock Deleted", HttpStatus.OK);
		
		//		return controllerService.deleteById(id, requestTokenHeader);
	}


	
	
	@PutMapping("/stock/{id}")
	public ResponseEntity<ServiceResponse<MedicineStock>> updateStockById(@PathVariable int id, @RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws MedicineStockNotFoundException, AuthorizationException{
		
		return new ResponseHandlers<MedicineStock>().defaultResponse(controllerService.updateById(id, medicineStock, requestTokenHeader), "Stock Updated", HttpStatus.OK);
		
	}


	
	
	
	
}
