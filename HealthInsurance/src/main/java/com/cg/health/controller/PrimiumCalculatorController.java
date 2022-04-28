package com.cg.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.health.service.PolicyPurchaseService;


@RestController
@RequestMapping("/health")
public class PrimiumCalculatorController {
	
	@Autowired
	public PolicyPurchaseService policyPurchaseService;

	@GetMapping("/primiumCalculator/{age}/{payingTerm}/{sumAssured}/{policyTerm}")
	public double calculatePrimium(@PathVariable int age,@PathVariable float payingTerm,@PathVariable double sumAssured,@PathVariable float policyTerm) {
		
		return policyPurchaseService.calculatePrimium(age, payingTerm, sumAssured, policyTerm);

	 }
}


