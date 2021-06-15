package com.cts.pmsm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.AuthorizationClient;
import com.cts.pmsm.model.RepSchedule;
import com.cts.pmsm.service.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
	ScheduleService schedule;
	
	@Autowired
	AuthorizationClient authorizationClient;
	
	
	@GetMapping("/healthCheck")
	public String health() {
		return "ok";
	}
	
	//Getting schedule start date from user, then mapping the representatives with doctors according to the medicines to form a schedule according to doctor's preffered time except on Sunday
	
	@GetMapping("/repSchedule/{scheduleStartDate}")
	public List<RepSchedule> getRepresentativeSchedule(@PathVariable(value="scheduleStartDate") String scheduleStartDate, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		
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
