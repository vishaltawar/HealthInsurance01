package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import com.cg.health.entities.PolicyPurchase;
import com.cg.health.exception.PolicyPurchaseAlreadyExistsException;
import com.cg.health.exception.PolicyPurchaseNotFoundException;

public interface PolicyPurchaseService {

	public List<PolicyPurchase> getPolicyPurchase() throws PolicyPurchaseNotFoundException; 
		
	

	public PolicyPurchase addPolicyPurchase(PolicyPurchase policyPurchase) throws PolicyPurchaseAlreadyExistsException;



	public Optional<PolicyPurchase> getPolicyPurchaseUserById(long policyPurchaseUserId) throws PolicyPurchaseNotFoundException; 

	public  double calculatePrimium(int age,float payingTerm,double sumAssured,float policyTerm);
}
