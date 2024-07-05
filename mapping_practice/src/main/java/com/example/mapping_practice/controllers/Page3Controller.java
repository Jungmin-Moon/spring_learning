package com.example.mapping_practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapping_practice.services.LoginManager;

@Controller
public class Page3Controller {

private final LoginManager loginManager;
	
	public Page3Controller(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	
	
	@GetMapping("/page3")
	public String page3(@RequestParam(required = false) String page4, @RequestParam(required = false) String page2, Model model) {
		
		if (page4 != null) {
			return "redirect:/page4";
		}
		
		if (page2 != null) {
			return "redirect:/page2";
		}
		
		String username = loginManager.getUsername();
		
		model.addAttribute("username", username);
	
		return "page3.html";
		
	}
}
