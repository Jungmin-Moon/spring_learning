package com.example.ch10_ex1.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ch10_ex1.model.Country;

@RestController
public class CountryController {
	//just showing off how to send objects in a response body
	/*
	@GetMapping("/france")
	public Country france() {
		Country c = Country.of("France", 67);
		
		return c;
	} */
	
	/*
	//can also return a list of them
	@GetMapping("/all")
	public List<Country> countries() {
		Country c1 = Country.of("France", 67);
		Country c2 = Country.of("Spain", 47);
		
		return List.of(c1, c2);
	} */
	
	//ResponseEntity
	@GetMapping("/france")
	public ResponseEntity<Country> france() {
		Country c = Country.of("France", 67);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.header("continent", "Europe")
							.header("capital", "Paris")
							.header("favorite_food", "cheese and wine")
							.body(c);
		
	}
}
