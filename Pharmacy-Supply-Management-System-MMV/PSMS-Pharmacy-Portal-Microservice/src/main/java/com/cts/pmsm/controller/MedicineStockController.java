package com.cts.pmsm.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.feign.MedicineStockFeign;
import com.cts.pmsm.model.DeleteStockInput;
import com.cts.pmsm.model.MedicineStock;

@Controller
@RequestMapping("/pharmacy")
public class MedicineStockController {

	@Autowired
	MedicineStockFeign stockClient;
	
	@GetMapping("/getStockInformation")
	public ModelAndView getStockInformation(HttpServletRequest request) throws Exception {
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		List<MedicineStock> stock=stockClient.getStockInformation((String) request.getSession().getAttribute("Authorization")).getBody().getData();
		
		ModelAndView model = new ModelAndView("medicine-stock-information");
		model.addObject("stockInfo", stock);
		return model;
	}
	
	
	
	
	
	
	
	@GetMapping("/addMedicine")
	public String showAddMedicinePage(@ModelAttribute("medicineStock") MedicineStock medicineStock,BindingResult result) {
		return "add-medicine-page";
	}
	
	@PostMapping("/addMedicine")
	public ModelAndView addMedicine(@ModelAttribute("medicineStock") MedicineStock medicineStock,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("add-medicine-page");
		
		if (medicineStock != null ) {
			try {
				stockClient.createMedicineStock(medicineStock, (String) request.getSession().getAttribute("Authorization"));
				model.addObject("success", "Medicine was successfully added to stock");
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "Medicine was not added!");
				return error;
			}
		}
		return model;
	}
	
	
	
	
	
	
	
	
	@GetMapping("/deleteMedicine")
	public String showDeleteMedicinePage(@ModelAttribute("deleteStockInput") DeleteStockInput deleteStockInput,BindingResult result) {
		return "delete-medicine-page";
	}
	
	@PostMapping("/deleteMedicine")
	public ModelAndView deleteMedicine(@ModelAttribute("deleteStockInput") DeleteStockInput deleteStockInput,BindingResult result,HttpServletRequest request) throws Exception{
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("delete-medicine-page");
		
		System.out.println(deleteStockInput);
		if (deleteStockInput != null ) {
			try {
				stockClient.deleteStockById(deleteStockInput.getId(), (String) request.getSession().getAttribute("Authorization"));
				model.addObject("success", "Medicine was deleted successfully!");
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "Medicine was not deleted!");
				return error;
			}
		}
		return model;
	}
	
	
	
	
	
	@GetMapping("/updateMedicine")
	public String showUpdateMedicinePage(@ModelAttribute("medicineStock") MedicineStock medicineStock,BindingResult result) {
		
		return "update-medicine-page";
	}
	
	@PostMapping("/updateMedicine")
	public ModelAndView updateMedicine(@ModelAttribute("medicineStock") MedicineStock medicineStock,BindingResult result,HttpServletRequest request) throws Exception{

		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		
		ModelAndView model = new ModelAndView("update-medicine-page");
		
		if (medicineStock != null ) {
			try {
				stockClient.updateStockById(medicineStock.getId(),medicineStock, (String) request.getSession().getAttribute("Authorization"));
				model.addObject("success", "Medicine was updated successfully!");
			}catch(Exception e) {
				ModelAndView error = new ModelAndView("error-page401");
				error.addObject("error", "Medicine was not updated!");
				return error;
			}
		}
		return model;
		
	}
	
	
	
	
	
	@ModelAttribute("listOfStock")
	public Set<Integer> populateProblemList(HttpServletRequest request) throws AuthorizationException{
		List<MedicineStock> stock=stockClient.getStockInformation((String) request.getSession().getAttribute("Authorization")).getBody().getData();
		Set<Integer> s=new LinkedHashSet<>();
		for(MedicineStock m:stock) {
			s.add(m.getId());
		}
		return s;
	}
}
