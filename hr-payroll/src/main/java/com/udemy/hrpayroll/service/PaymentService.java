package com.udemy.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.hrpayroll.entity.Payment;
import com.udemy.hrpayroll.entity.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String hrWorkerHost;
	
	public Payment getPayment(Long workerId, int days) {
		Map<String, Long>uriVariables = new HashMap<>();
		uriVariables.put("id", workerId);
		
		Worker worker = restTemplate.getForObject(hrWorkerHost + "/workers/{id}", Worker.class, uriVariables);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
