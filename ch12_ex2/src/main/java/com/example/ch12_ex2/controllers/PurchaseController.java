package com.example.ch12_ex2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ch12_ex2.model.Purchase;
import com.example.ch12_ex2.repositories.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	private final PurchaseRepository purchaseRepository;
	
	public PurchaseController(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}
	
	@PostMapping
	public void storePurchase(@RequestBody Purchase purchase) {
		purchaseRepository.storePurchase(purchase);
	}
	
	@GetMapping
	public List<Purchase> findPurchases() {
		return purchaseRepository.findAllPurchases();
	}
}
