package com.cts.pmsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.MedicineStockRepository;
import com.cts.pmsm.model.MedicineStock;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	MedicineStockRepository medicineStockRepository;
	
	@Override
	public List<MedicineStock> getAllMedicineStock() {
		List<MedicineStock> stock= medicineStockRepository.findAll();
		return stock;
	}

	
}
