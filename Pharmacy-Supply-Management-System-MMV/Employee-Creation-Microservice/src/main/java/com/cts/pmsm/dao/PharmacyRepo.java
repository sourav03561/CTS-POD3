package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{

}
