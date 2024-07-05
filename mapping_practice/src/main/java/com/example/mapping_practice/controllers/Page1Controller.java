package com.example.mapping_practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapping_practice.services.LoginManager;

@Controller
public class Page1Controller {
	private final LoginManager loginManager;
	
	public Page1Controller(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	
	
	@GetMapping("/page1")
	public String page1(@RequestParam(required = false) String logout, @RequestParam(required = false) String page2, Model model) {
		
		if (logout != null) {
			loginManager.setUsername(null);
		}
		
		if (page2 != null) {
			return "redirect:/page2";
		}
		
		String username = loginManager.getUsername();
		
		if (username == null) {
			return "redirect:/";
		}
		
		model.addAttribute("username", username);
		return "page1.html";
	}
}
