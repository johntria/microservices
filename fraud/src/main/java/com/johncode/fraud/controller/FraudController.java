package com.johncode.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johncode.clients.fraud.FraudCheckResponse;
import com.johncode.fraud.service.FraudCheckService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
	private FraudCheckService fraudCheckService;

	@GetMapping(path="{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerID){
		log.info("Fraud request in order to see if customer with id:{} is fraud",customerID);
		boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
		return new FraudCheckResponse(fraudulentCustomer);
	}
}