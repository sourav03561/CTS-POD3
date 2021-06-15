package com.cts.pmsm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pmsm.feign.RepScheduleClient;
import com.cts.pmsm.model.RepSchedule;
import com.cts.pmsm.model.RepScheduleInput;


@Controller
@RequestMapping("/pharmacy")
public class RepScheduleController {
	
	@Autowired
	RepScheduleClient repClient;
	
	
	@GetMapping("/getRepSchedule")
	public String showRepSchedulePage(@ModelAttribute("repScheduleInput") RepScheduleInput repScheduleInput,BindingResult result) {
		return "representative-schedule-page";
	}
	
	@PostMapping("/getRepSchedule")
	public ModelAndView getRepSchedulePage(@ModelAttribute("repScheduleInput") RepScheduleInput repScheduleInput,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("representative-schedule-page");
		if (repScheduleInput != null ) {
			try {
				
				List<RepSchedule> schedule=repClient.getRepresentativeSchedule(repScheduleInput.getDate(),(String) request.getSession().getAttribute("Authorization")).getBody().getData();
				model.addObject("repSchedule", schedule);
			}
			catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "ERROR HERE in REPSCHEDULE");
				return error;
			}
		}
		return model;
	}

}
