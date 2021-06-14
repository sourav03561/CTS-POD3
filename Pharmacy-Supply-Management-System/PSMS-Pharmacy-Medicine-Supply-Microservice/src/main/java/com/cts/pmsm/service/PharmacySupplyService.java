package com.cts.pmsm.service;

import java.util.List;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;

public interface PharmacySupplyService {

	public List<PharmacyMedicineSupply> getPharmacySupplyFromService(List<MedicineDemand> medicineDemand);
}
