package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pmsm.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer>{

}
