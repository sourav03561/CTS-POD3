package com.cts.pmsm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.RepSchedule;
import com.cts.pmsm.model.ServiceResponse;

@FeignClient("MEDICAL-REPRESENTATIVE-SCHEDULE-MICROSERVICE")
public interface RepScheduleClient {
	
	@GetMapping("/repSchedule/{scheduleStartDate}")
	public ResponseEntity<ServiceResponse<List<RepSchedule>>>  getRepresentativeSchedule(@PathVariable(value="scheduleStartDate") String scheduleStartDate, @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws AuthorizationException;

}
