package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.MedicalRepresentative;

@Repository
public interface MedicalRepresentativeRepo extends JpaRepository<MedicalRepresentative, Integer>{

}
