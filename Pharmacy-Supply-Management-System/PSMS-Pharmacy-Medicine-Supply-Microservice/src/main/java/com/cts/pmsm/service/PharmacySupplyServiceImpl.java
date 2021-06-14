package com.cts.pmsm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.PharmacyRepository;
import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.MedicineStockClient;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.model.Pharmacy;
import com.cts.pmsm.model.PharmacyMedicineSupply;

@Service
public class PharmacySupplyServiceImpl implements PharmacySupplyService {
	

	
	@Autowired
	MedicineStockClient medicineStockClient;
	
	@Autowired
	PharmacyRepository pharmacyRepository;
	
	
	
	public List<Pharmacy> getPharmacies(){
		return pharmacyRepository.findAll();
	}
	
	
	

	public List<PharmacyMedicineSupply> getPharmacySupplyFromService(List<MedicineDemand> medicineDemand){
		
		List<String> pharmacies=new ArrayList<>();
		
		for(Pharmacy p:getPharmacies()) {
			pharmacies.add(p.getPharmacyName());
		}
		
		
		List<MedicineStock> medicineStock= medicineStockClient.getStockInformation(); //Pass jwt token here
		List<PharmacyMedicineSupply> res=new ArrayList<>();
		
		
		
		for(MedicineDemand demand: medicineDemand) {
			int val=0;
			for(MedicineStock stock: medicineStock) {
				if(stock.getName().equalsIgnoreCase(demand.getMedicineName()) && stock.getNumberOfTabletsInStock()>=demand.getDemandCount()) {
					val=stock.getNumberOfTabletsInStock()-demand.getDemandCount();
					for(String p:pharmacies) {
						PharmacyMedicineSupply pms=new PharmacyMedicineSupply();
						pms.setPharmacyName(p);
						pms.setMedicineName(demand.getMedicineName());
						pms.setSupplyCount((demand.getDemandCount())/(pharmacies.size()));
						res.add(pms);
					}
					
				}
				else if(stock.getName().equalsIgnoreCase(demand.getMedicineName()) && stock.getNumberOfTabletsInStock()<demand.getDemandCount()) {
					for(String p:pharmacies) {
						PharmacyMedicineSupply pms=new PharmacyMedicineSupply();
						pms.setPharmacyName(p);
						pms.setMedicineName(demand.getMedicineName());
						pms.setSupplyCount((stock.getNumberOfTabletsInStock())/(pharmacies.size()));
						res.add(pms);
					}
				}
				
				updateMedicineStock(demand.getMedicineName(),val); //Pass jwt token here
				
			}
		}
		
		
		return res;
		
	}
	
	
	public boolean updateMedicineStock(String medicineName, int count) {
		return medicineStockClient.updateNumberOfTabletsInStockByName(medicineName, count);
	}
}
