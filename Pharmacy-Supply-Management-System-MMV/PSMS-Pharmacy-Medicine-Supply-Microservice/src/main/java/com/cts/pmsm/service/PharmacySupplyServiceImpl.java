package com.cts.pmsm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.MedicineDemandRepo;
import com.cts.pmsm.dao.PharmacyMedicineSupplyRepo;
import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.EmployeeClient;
import com.cts.pmsm.feign.MedicineStockClient;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.model.Pharmacy;
import com.cts.pmsm.model.PharmacyMedicineSupply;
import com.cts.pmsm.model.ServiceResponse;

@Service
public class PharmacySupplyServiceImpl implements PharmacySupplyService {
	

	
	@Autowired
	MedicineStockClient medicineStockClient;
	
	@Autowired
	EmployeeClient emp;
	
	@Autowired
	MedicineDemandRepo demandRepo;
	
	@Autowired
	PharmacyMedicineSupplyRepo supplyRepo;
	
	
	public List<Pharmacy> getPharmacies(String token) throws AuthorizationException{
		return emp.getPharmacies(token).getBody().getData();
	}
	
	
	

	public List<PharmacyMedicineSupply> getPharmacySupplyFromService(List<MedicineDemand> medicineDemand,String token) throws AuthorizationException{
		
		List<String> pharmacies=new ArrayList<>();
		
		for(Pharmacy p:getPharmacies(token)) {
			pharmacies.add(p.getPharmacyName());
		}
		
		
		
		ResponseEntity<ServiceResponse<List<MedicineStock>>> ms= medicineStockClient.getStockInformation(token);
		List<MedicineStock> medicineStock=ms.getBody().getData();
		
		for(MedicineStock m:medicineStock) {
			System.out.println(m.getName());
		}
		
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
				
				updateMedicineStock(token,demand.getMedicineName(),val);
				
			}
		}
		
		
		demandRepo.saveAll(medicineDemand);
		supplyRepo.saveAll(res);
		
		
		return res;
		
	}
	
	
	public boolean updateMedicineStock(String token, String medicineName, int count) throws AuthorizationException {
		
		return medicineStockClient.updateNumberOfTabletsInStockByName(token, medicineName, count).getBody().getData();
	}




	@Override
	public List<MedicineDemand> getAllDemand(String token) {

		List<MedicineDemand> md=demandRepo.findAll();
		return md;
	}




	@Override
	public List<PharmacyMedicineSupply> getAllSupply(String token) {

		List<PharmacyMedicineSupply> pms=supplyRepo.findAll();
		return pms;
	}
}
