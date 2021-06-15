package com.cts.pmsm.controller;

import java.util.ArrayList;
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

import com.cts.pmsm.feign.MedicineSupplyClient;
import com.cts.pmsm.model.MedicineDemand;
import com.cts.pmsm.model.PharmacyMedicineSupply;


@Controller
@RequestMapping("/pharmacy")
public class PharmacyMedicineSupplyController {
	
	@Autowired
	MedicineSupplyClient supplyClient;
	
	
	@GetMapping("/medicineSupply")
	public String showRepSchedulePage(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand,BindingResult result) {
		return "medicine-supply-page";
	}
	
	@PostMapping("/medicineSupply")
	public ModelAndView getRepSchedulePage(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("medicine-supply-page");
		
		List<MedicineDemand> demand=new ArrayList<>();
		demand.add(medicineDemand);
		
		if (medicineDemand != null ) {
			try {
				List<PharmacyMedicineSupply> list=supplyClient.getPharmacySupply(demand, (String) request.getSession().getAttribute("Authorization"));
				model.addObject("pharmacyMedicineSupply", list);
				
				
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "ID NOT FOUND, Please enter the ID carefully!");
				return error;
			}
			
		}
		return model;
		
	}

}
