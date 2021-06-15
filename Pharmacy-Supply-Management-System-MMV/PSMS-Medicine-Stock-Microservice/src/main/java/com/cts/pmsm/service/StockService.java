package com.cts.pmsm.service;

import java.util.List;

import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.MedicineStock;


public interface StockService {

	public List<MedicineStock> getAllMedicineStock();
	public boolean updateStock(String medicineName, int count);
	
	public MedicineStock createMedicineStock(MedicineStock ms);
	
	public MedicineStock getStockById(int id) throws MedicineStockNotFoundException;
	
	public MedicineStock updateStockById(int id, MedicineStock ms) throws MedicineStockNotFoundException;
	
	public void deleteStockById(int id);
}
