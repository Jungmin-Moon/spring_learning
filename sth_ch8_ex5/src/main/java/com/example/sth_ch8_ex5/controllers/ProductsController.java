package com.example.sth_ch8_ex5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sth_ch8_ex5.model.Product;
import com.example.sth_ch8_ex5.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ProductsController {
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping("/products") 
	public String viewProducts(Model model) {
		var products = productService.findAll();
		model.addAttribute("products", products);
		
		return "products.html";
	}
	
	//in this case we do need to say path = ""
	//this is if we only use the general use @RequestMapping
	/*
	@PostMapping("/products")
	public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		productService.addProduct(p);
		
		var products = productService.findAll();
		model.addAttribute("products", products);
		
		return "products.html";
	} */
	
	//this does the same as above while creating less lines
	//this also works because in this example the Product class
	//has the variables name and price
	//in the products.html page the data being sent is also named Name and price
	//which is why this works and if you can get away with doing this do so.
	@PostMapping("/products")
	public String addProduct(Product p, Model model) {
		
		//because of how Product and products.html is setup
		//Spring when sent the data from the client sees that oh they are sending data from
		//names name and price from the html
		//seeing this it automatically matches those values to the variables in Product
		//allowing the programmer to just pass in the Product p parameter along with the Model
		//so instead of typing out the setName and setPrice we can just add the product
		productService.addProduct(p);
		
		var products = productService.findAll();
		model.addAttribute("products", products);
		
		return "products.html";
	}
	
	
	
}
