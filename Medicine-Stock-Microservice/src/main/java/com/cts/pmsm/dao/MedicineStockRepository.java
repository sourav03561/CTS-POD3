package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.MedicineStock;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Integer> {

}
