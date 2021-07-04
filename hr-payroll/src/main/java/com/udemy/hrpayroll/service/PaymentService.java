package com.udemy.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.hrpayroll.client.WorkerClient;
import com.udemy.hrpayroll.entity.Payment;
import com.udemy.hrpayroll.entity.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerClient workerClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = workerClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
