package com.cts.pmsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.MedicineStockRepository;
import com.cts.pmsm.exception.MedicineStockNotFoundException;
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

	
	
	
	@Override
	public MedicineStock createMedicineStock(MedicineStock ms) {
		MedicineStock medicineStock=medicineStockRepository.save(ms);
		return medicineStock;
	}

	@Override
	public MedicineStock getStockById(int id) throws MedicineStockNotFoundException {
		MedicineStock medicineStock=null;
		medicineStock=medicineStockRepository.findById(id).orElseThrow(() -> new MedicineStockNotFoundException("Medicine Stock not found"));
		return medicineStock;
	}

	@Override
	public MedicineStock updateStockById(int id, MedicineStock ms) throws MedicineStockNotFoundException{
		MedicineStock medicineStock=getStockById(id);
		medicineStock.setName(ms.getName());
		medicineStock.setChemicalComposition(ms.getChemicalComposition());
		medicineStock.setDateOfExpiry(ms.getDateOfExpiry());
		medicineStock.setTargetAilment(ms.getTargetAilment());
		medicineStock.setNumberOfTabletsInStock(ms.getNumberOfTabletsInStock());
		
		MedicineStock ms1=medicineStockRepository.save(medicineStock);
		return ms1;
	}

	@Override
	public void deleteStockById(int id) {
		medicineStockRepository.deleteById(id);
		
	}



	

	
}
