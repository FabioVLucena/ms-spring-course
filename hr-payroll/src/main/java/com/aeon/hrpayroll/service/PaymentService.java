package com.aeon.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.aeon.hrpayroll.entity.Payment;
import com.aeon.hrpayroll.entity.Worker;
import com.aeon.hrpayroll.feignclient.WorkerFeignClient;

@Service
public class PaymentService {

	private WorkerFeignClient workerClient;
	
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerClient = workerFeignClient;
	}
	
	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
