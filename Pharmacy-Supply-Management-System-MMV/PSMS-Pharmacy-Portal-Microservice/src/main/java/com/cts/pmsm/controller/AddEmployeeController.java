package com.cts.pmsm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pmsm.feign.AddEmployeeClient;
import com.cts.pmsm.model.MedicalRepresentative;
import com.cts.pmsm.model.Pharmacy;

@Controller
@RequestMapping("/pharmacy")
public class AddEmployeeController {
	
	@Autowired
	AddEmployeeClient addEmployeeClient;
	
	
	@GetMapping("/addPharmacy")
	public String showAddPharmacyPage(@ModelAttribute("pharmacy") Pharmacy pharmacy,BindingResult result) {
		return "add-pharmacy";
	}
	
	@PostMapping("/addPharmacy")
	public ModelAndView addPharmacy(@ModelAttribute("pharmacy") Pharmacy pharmacy,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("add-pharmacy");
		
		if(pharmacy!=null) {
			try {
				addEmployeeClient.addPharmacy(pharmacy, (String) request.getSession().getAttribute("Authorization"));
				model.addObject("success", "Pharmacy added successfully!!");
				
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "ID NOT FOUND, Please enter the ID carefully!");
				return error;
			}
		}
		return model;
	}
	
	
	@GetMapping("/addRepresentative")
	public String showAddRepresentative(@ModelAttribute("medicalRepresentative") MedicalRepresentative medicalRepresentative,BindingResult result) {
		return "add-representative";
	}
	
	@PostMapping("/addRepresentative")
	public ModelAndView addRepresentative(@ModelAttribute("medicalRepresentative") MedicalRepresentative medicalRepresentative,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("add-representative");
		
		if(medicalRepresentative!=null) {
			try {
				
				addEmployeeClient.addRepresentative(medicalRepresentative, (String) request.getSession().getAttribute("Authorization"));
				model.addObject("success", "Representative added successfully!!");
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "ID NOT FOUND, Please enter the ID carefully!");
				return error;
			}
		}
		return model;
		
	}

}
