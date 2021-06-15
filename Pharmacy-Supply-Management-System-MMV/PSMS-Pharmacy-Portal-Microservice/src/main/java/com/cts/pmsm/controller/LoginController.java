package com.cts.pmsm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.pmsm.feign.AuthorizingClient;
import com.cts.pmsm.model.JwtRequest;


@Controller
@RequestMapping("/pharmacy")
public class LoginController {
	
	@Autowired
	AuthorizingClient client;
	
	@GetMapping(value = "/login")
	public String showLoginPage(@ModelAttribute("user") JwtRequest user, Model model) {
		return "login";
	}
	
	
	@GetMapping(value = "/logout")
	public String logoutAndShowLoginPage(Model model, HttpServletRequest request) {
		/*
		 * set session as invalidate 
		 * set username to null
		 */
		request.getSession().invalidate();
		model.addAttribute("username", null);
		return "redirect:/pharmacy/login";
	}
	
	
	
	@PostMapping(value = "/login")
	public String afterLoginAuthenticateAndRedirect(@ModelAttribute("user") JwtRequest user, Model model,
			HttpServletRequest request) {
		/*
		 * call authentication microservice client
		 * generate the token
		 * if excepyions occured while generating token, redirect to same view
		 * otherwise return welcome view
		 */
		ResponseEntity<?> responseGenerated = null;
		try {
			
			responseGenerated = client.createAuthenticationToken(user);
			

		} catch (Exception e) {
			System.out.println(e.getMessage()+"=========================");
			e.printStackTrace();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}
		/*
		 * retreive jwt token from map set it to session
		 */
		@SuppressWarnings("unchecked")
		Map<String, String> tokenMap = (Map<String, String>) responseGenerated.getBody();
		String token = tokenMap.get("token");
		
		request.getSession().setAttribute("Authorization", "Bearer " + token);
		request.getSession().setAttribute("userName", user.getUserName());
		model.addAttribute("userName",  user.getUserName());
		return "welcome-page";
	}

}
