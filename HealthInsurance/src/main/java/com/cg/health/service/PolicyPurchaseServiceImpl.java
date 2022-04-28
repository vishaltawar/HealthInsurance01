package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.PolicyPurchaseDao;
import com.cg.health.entities.Policy;
import com.cg.health.entities.PolicyPurchase;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.exception.PolicyPurchaseAlreadyExistsException;
import com.cg.health.exception.PolicyPurchaseNotFoundException;

@Service
public class PolicyPurchaseServiceImpl implements PolicyPurchaseService {

	@Autowired
	private PolicyPurchaseDao policyPurchaseDao;
	
	

	@Override
	public PolicyPurchase addPolicyPurchase(PolicyPurchase policyPurchase)throws PolicyPurchaseAlreadyExistsException {
		if (policyPurchaseDao.existsById(policyPurchase.getPolicyPurchaseId())) {
            throw new PolicyPurchaseAlreadyExistsException();
        }
        PolicyPurchase savedPolicyPurchase = policyPurchaseDao.save(policyPurchase);
        return savedPolicyPurchase;
		//return policyPurchaseDao.save(policyPurchase);
	}

	@Override
	public Optional<PolicyPurchase> getPolicyPurchaseUserById(long policyPurchaseUserId) throws PolicyPurchaseNotFoundException {
		// TODO Auto-generated method stub
		  PolicyPurchase policyPurchase;
	        if (policyPurchaseDao.findById(policyPurchaseUserId).isEmpty()) {
	            throw new PolicyPurchaseNotFoundException();
	        } else {
	            policyPurchase = policyPurchaseDao.findById(policyPurchaseUserId).get();
	        }
	        return Optional.of(policyPurchase);
	    }
		//return policyPurchaseDao.getById(policyPurchaseUserId);
	

	@Override
	public double calculatePrimium(int age, float payingTerm, double sumAssured, float policyTerm) {

		double primium=1;
		if(age<=18) {
			primium=sumAssured/(12*payingTerm)*1.1;
		}
		if(age<=30) {
			primium=sumAssured/(12*payingTerm)*1.2;
		}
		if(age<=50) {
			primium=sumAssured/(12*payingTerm)*1.4;
		}
		if(age<=100) {
			primium=sumAssured/(12*payingTerm)*1.5;
		}
		return primium;
	}
		@Override
		public List<PolicyPurchase> getPolicyPurchase() throws PolicyPurchaseNotFoundException {
			
			return policyPurchaseDao.findAll();
		}

}
