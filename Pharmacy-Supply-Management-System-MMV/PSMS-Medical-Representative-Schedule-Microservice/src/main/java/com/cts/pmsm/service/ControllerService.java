package com.cts.pmsm.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.RepSchedule;

@Service
public class ControllerService {

	@Autowired
	AuthorizationClient authorizationClient;
	
	@Autowired
	ScheduleService schedule;
	
	public List<RepSchedule> repSchedule(String scheduleStartDate, String requestTokenHeader)
			throws AuthorizationException {
		if (authorizationClient.authorizeTheRequest(requestTokenHeader)) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			LocalDate date = LocalDate.parse(scheduleStartDate, formatter);
			
			List<RepSchedule> reps= schedule.getRepSchedule(date, requestTokenHeader);
			
			return reps;
			
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	
}
