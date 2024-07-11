package com.example.ch11_ex1.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.ch11_ex1.model.Payment;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {
	
	@PostMapping("/payment")
	Payment createPayment(
			@RequestHeader String requestId,
			@RequestBody Payment payment);

}
