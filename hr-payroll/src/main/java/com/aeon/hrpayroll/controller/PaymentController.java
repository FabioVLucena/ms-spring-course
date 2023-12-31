package com.aeon.hrpayroll.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.hrpayroll.entity.Payment;
import com.aeon.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);
		
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment payment = new Payment("Faker", 700.0, days);
		
		return ResponseEntity.status(HttpStatus.OK).body(payment);		
	}
	
}
