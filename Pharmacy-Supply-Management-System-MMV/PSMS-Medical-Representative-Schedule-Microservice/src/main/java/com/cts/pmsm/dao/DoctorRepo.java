package com.cts.pmsm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pmsm.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

}
