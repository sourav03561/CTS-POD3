package com.cts.pmsm.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.pmsm.dao.DoctorRepo;
import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.EmployeeClient;
import com.cts.pmsm.feign.MedicineStockClient;
import com.cts.pmsm.model.Doctor;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.model.RepSchedule;
import com.cts.pmsm.model.ServiceResponse;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	MedicineStockClient stockClient;
	
	@Autowired
	EmployeeClient emp;

	@Autowired
	DoctorRepo doctorRepo;


	public List<Doctor> getDoctors() {
		return doctorRepo.findAll();
	}

	public List<MedicalRepresentative> getRepresentatives(String token) throws AuthorizationException {
		return emp.getRepresentatives(token).getBody().getData();
	}

	public List<RepSchedule> getRepSchedule(LocalDate startDate, String token) throws AuthorizationException {

		List<RepSchedule> rep = new ArrayList<>();
		List<Doctor> doctors = getDoctors();
		List<MedicalRepresentative> medicalRepresentatives = getRepresentatives(token);
		LocalDate localDate = startDate;

		LocalTime now = LocalTime.now();
		LocalTime one = LocalTime.of(13, 0);
		LocalDate today = LocalDate.now();

		if (startDate.isBefore(today)) {
			return rep;
		}
		if (startDate.equals(today)) {
			if (now.isAfter(one)) {
				localDate = localDate.plusDays(1);
			}
		}

		
		for (int i = 0; i < doctors.size(); i++) {

			if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				localDate = localDate.plusDays(1);
			}

			Doctor doctor = doctors.get(i);
			MedicalRepresentative medicalRep = medicalRepresentatives.get(i % (medicalRepresentatives.size()));

			RepSchedule repSchedule = new RepSchedule();
			repSchedule.setRepName(medicalRep.getName());
			repSchedule.setDoctorName(doctor.getName());
			repSchedule.setDoctorContactNumber(doctor.getContactNumber());
			repSchedule.setMeetingDate(localDate);
			repSchedule.setMeetingSlot(doctor.getPreferredSlot());
			repSchedule.setTreatingAilment(doctor.getTreatingAilment());
			repSchedule.setMedicines(getMedicineByAilment(doctor.getTreatingAilment(), token));

			rep.add(repSchedule);

			localDate = localDate.plusDays(1);

		}
		return rep;

	}

	public List<String> getMedicineByAilment(String ailment, String token) throws AuthorizationException {

		List<String> meds = new ArrayList<String>();

		ResponseEntity<ServiceResponse<List<MedicineStock>>> resp= stockClient.getStockInformation(token);
		List<MedicineStock> stock=resp.getBody().getData();
		
		for (MedicineStock ms : stock) {
			if (ms.getTargetAilment().equalsIgnoreCase(ailment)) {
				meds.add(ms.getName());
			}
		}
		return meds;

	}

}
