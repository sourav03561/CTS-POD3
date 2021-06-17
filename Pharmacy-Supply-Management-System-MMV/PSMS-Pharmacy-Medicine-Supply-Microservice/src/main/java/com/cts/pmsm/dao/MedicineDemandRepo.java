package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.MedicineDemand;

@Repository
public interface MedicineDemandRepo extends JpaRepository<MedicineDemand, Integer> {

}
