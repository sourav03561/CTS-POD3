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
//import com.cts.pmsm.exception.AuthorizationException;
//import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.service.StockService;

@RestController
public class MedicineStockController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	AuthorizationClient authorizationClient;
	
	@GetMapping("/healthCheck")
	public String health() {
		return "working";
	}
	
	@GetMapping("/medicineStockInformation")
	public List<MedicineStock> getStockInformation(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			List<MedicineStock> stock= stockService.getAllMedicineStock();
			return stock;
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
	}
	
	@PostMapping("/updateStock/{medicineName}/{count}")
	public boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String requestTokenHeader, @PathVariable("medicineName") String medicine, @PathVariable("count") int count) throws AuthorizationException {
		boolean res=false;
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			res=stockService.updateStock(medicine, count);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		return res;
	}
	
	//=====================================================================
	
	
	@PutMapping("/createMedicineStock")
	public ResponseEntity createMedicineStock(@RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock ms=stockService.createMedicineStock(medicineStock);
			return new ResponseEntity(HttpStatus.CREATED);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@GetMapping("/getStock/{id}")
	public ResponseEntity<MedicineStock> getStockById(@PathVariable int id,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws MedicineStockNotFoundException, AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock stock= stockService.getStockById(id);
			return new ResponseEntity<>(stock, HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
		
	}
	
	@DeleteMapping("/deleteStock/{id}")
	public ResponseEntity deleteStockById(@PathVariable int id,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			stockService.deleteStockById(id);
			return new ResponseEntity(HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	@PutMapping("/updateStock/{id}")
	public ResponseEntity<MedicineStock> updateStockById(@PathVariable int id, @RequestBody MedicineStock medicineStock,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws MedicineStockNotFoundException, AuthorizationException{
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock stock=stockService.updateStockById(id, medicineStock);
			return new ResponseEntity<MedicineStock>(stock,HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		
	}
	
	
	
}
