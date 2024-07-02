package com.example.sth_ch8_ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	/*
	@RequestMapping("/home")
	public String home(Model page) {
		page.addAttribute("username", "Katy");
		page.addAttribute("color", "red");
		return "home.html";
	} */
	
	//Request Parameters
	/*
	@RequestMapping("/home")
	public String home(@RequestParam String color, Model page) {
		page.addAttribute("username", "Katy");
		page.addAttribute("color", color);
		return "home.html";
	}
	*/
	
	//Path Variables
	//minimal difference with request parameters but instead of using key-value pairs
	//we just get the value directly
	//ie localhost:8080/home/insert_color
	@RequestMapping("/home/{color}")
	public String home(@PathVariable String color, Model page) {
		page.addAttribute("username", "Katy");
		page.addAttribute("color", color);
		return "home.html";
	}
}
