package com.cts.pmsm.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.MedicineStock;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE medicine_stock M SET M.number_of_tablets_in_stock =?2 where M.name =?1", nativeQuery = true)
	void updateMedicineStock(String medicine, int count);
}
