package com.cts.pmsm.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.Doctor;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.RepSchedule;

public interface ScheduleService {

	public List<RepSchedule> getRepSchedule(LocalDate startDate, String token) throws AuthorizationException;
	
	public List<Doctor> getDoctors();
	
	public List<MedicalRepresentative> getRepresentatives();
}
