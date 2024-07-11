package com.example.ch11_ex1.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ch11_ex1.model.Payment;
import com.example.ch11_ex1.proxy.PaymentsProxy;

@RestController
public class PaymentsController {
	
	private final PaymentsProxy paymentsProxy;
	
	public PaymentsController(PaymentsProxy paymentsProxy) {
		this.paymentsProxy = paymentsProxy;
	}
	
	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		String requestId = UUID.randomUUID().toString();
		
		return paymentsProxy.createPayment(requestId, payment);
	}
}
