package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
}
