package com.cts.pmsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.MedicineStock;

@Service
public class ControllerService {

	@Autowired
	AuthorizationClient authorizationClient;
	
	@Autowired
	StockService stockService;
	
	
	//For getStockInformation
	public List<MedicineStock> showStock(String requestTokenHeader)
			throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			List<MedicineStock> stock= stockService.getAllMedicineStock();
			return stock;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	
	//For updateNumberOfTabletsInStockByName
	public boolean updateCountByName(String requestTokenHeader, String medicine, int count)
			throws AuthorizationException {
		boolean res=false;
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			res=stockService.updateStock(medicine, count);
		}else {
			throw new AuthorizationException("Not allowed");
		}
		return res;
	}
	
	
	
	//For createMedicineStock
	public MedicineStock create(MedicineStock medicineStock, String requestTokenHeader)
			throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock ms=stockService.createMedicineStock(medicineStock);
			return ms;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	//For getStockById
	public MedicineStock getByID(int id, String requestTokenHeader)
			throws MedicineStockNotFoundException, AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock stock= stockService.getStockById(id);
			return stock;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	//For deleteStockByID
	public ResponseEntity<?> deleteById(int id, String requestTokenHeader) throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			stockService.deleteStockById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	//For UpdateStockById
	public MedicineStock updateById(int id, MedicineStock medicineStock, String requestTokenHeader)
			throws MedicineStockNotFoundException, AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			MedicineStock stock=stockService.updateStockById(id, medicineStock);
			return stock;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
}
