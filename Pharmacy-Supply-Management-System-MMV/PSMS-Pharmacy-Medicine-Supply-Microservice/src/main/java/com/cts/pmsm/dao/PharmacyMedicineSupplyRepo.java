package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.PharmacyMedicineSupply;

@Repository
public interface PharmacyMedicineSupplyRepo extends JpaRepository<PharmacyMedicineSupply, Integer>{

}
