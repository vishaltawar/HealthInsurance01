package com.cg.health.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.health.entities.Policy;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.service.PolicyService;
import com.cg.health.service.PolicyServiceImpl;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/health/policies")
public class PolicyController {
	@Autowired
	public PolicyServiceImpl policyService;
	
	@GetMapping(value="/getall", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Policy>> getPolicyList() throws Exception{
		 List<Policy> policylist=policyService.getPolicies();
		 if(policylist.isEmpty())
		 {
			 return new ResponseEntity("Sorry! Policy not available!",
					 HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<List<Policy>>(policylist, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy1) {
		Policy policy2= policyService.addPolicies(policy1);
		if(policy2==null)
		{
			return new ResponseEntity("Sorry! Policy Already available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Policy>(policy2, HttpStatus.OK);	
	}


			
	@GetMapping(value="/get/{policyId}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Optional<Policy>> getPolicyById(@PathVariable int policyId){
		Optional<Policy> policy1= policyService.getPolicyById(policyId);
		if(policy1==null)
		{
			return new ResponseEntity("Sorry! Policy not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Policy>>(policy1, HttpStatus.OK);
	}
}
