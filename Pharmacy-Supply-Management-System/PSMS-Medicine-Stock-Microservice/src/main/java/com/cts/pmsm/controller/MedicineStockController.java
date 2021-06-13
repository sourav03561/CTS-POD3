package com.cts.pmsm.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.service.StockService;

@RestController
public class MedicineStockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/healthCheck")
	public String health() {
		return "working";
	}
	
	@GetMapping("/medicineStockInformation")
	public List<MedicineStock> getStockInformation(){
		List<MedicineStock> stock= stockService.getAllMedicineStock();
		return stock;
	}
	
	//=====================================================================
	
	
	@PostMapping("/createMedicineStock")
	public ResponseEntity createMedicineStock(@RequestBody MedicineStock medicineStock){
		MedicineStock ms=stockService.createMedicineStock(medicineStock);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/getStock/{id}")
	public ResponseEntity<MedicineStock> getStockById(@PathVariable int id) throws MedicineStockNotFoundException{
		 MedicineStock stock= stockService.getStockById(id);
		return new ResponseEntity<>(stock, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStock/{id}")
	public ResponseEntity deleteStockById(@PathVariable int id){
		stockService.deleteStockById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/updateStock/{id}")
	public ResponseEntity<MedicineStock> updateStockById(@PathVariable int id, @RequestBody MedicineStock medicineStock) throws MedicineStockNotFoundException{
		MedicineStock stock=stockService.updateStockById(id, medicineStock);
		return new ResponseEntity<MedicineStock>(stock,HttpStatus.OK);
	}
	
	
	
}
