package com.aeon.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.aeon.hrpayroll.entity.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Athos", 200.0, days);
	}
	
}
