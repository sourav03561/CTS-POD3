package com.cts.pmsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.handler.ResponseHandlers;
import com.cts.pmsm.model.RepSchedule;
import com.cts.pmsm.model.ServiceResponse;
import com.cts.pmsm.service.ControllerService;

@RestController
public class ScheduleController {

	@Autowired
	ControllerService controllerService;
	
	
	@GetMapping("/healthCheck")
	public String health() {
		return "ok";
	}
	
	//Getting schedule start date from user, then mapping the representatives with doctors according to the medicines to form a schedule according to doctor's preffered time except on Sunday
	
	@GetMapping("/repSchedule/{scheduleStartDate}")
	public ResponseEntity<ServiceResponse<List<RepSchedule>>>  getRepresentativeSchedule(@PathVariable(value="scheduleStartDate") String scheduleStartDate, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException{
		
		return new ResponseHandlers<List<RepSchedule>>().defaultResponse(controllerService.repSchedule(scheduleStartDate, requestTokenHeader), "Prepared Schedule", HttpStatus.OK);
		
	}

	

}
