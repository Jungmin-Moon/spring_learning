package com.example.mapping_practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapping_practice.services.LoginManager;

@Controller
public class Page4Controller {

private final LoginManager loginManager;
	
	public Page4Controller(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	
	
	@GetMapping("/page4")
	public String page4(@RequestParam(required = false) String page3, @RequestParam(required = false) String page1, Model model) {
	
		if (page3 != null) {
			return "redirect:/page3";
		}
		
		if (page1 != null) {
			return "redirect:/page1";
		}
		
		String username = loginManager.getUsername();
		
		model.addAttribute("username", username);
	
		return "page4.html";
		
	}
}
