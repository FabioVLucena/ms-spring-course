package com.aeon.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aeon.hrpayroll.entity.Payment;
import com.aeon.hrpayroll.entity.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String HR_WORKER_HOST;
	
	private RestTemplate restTemplate;
	
	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Payment getPayment(Long workerId, Integer days) {
		Map<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("id", workerId.toString());
		
		String url = HR_WORKER_HOST + "/workers/{id}";
		
		Worker worker = restTemplate.getForObject(url, Worker.class, uriVariable); 
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
