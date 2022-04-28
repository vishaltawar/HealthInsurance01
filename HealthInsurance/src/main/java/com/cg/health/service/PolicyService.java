package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import com.cg.health.entities.Policy;
import com.cg.health.exception.BadRequestException;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;


public interface PolicyService {

	public List<Policy> getPolicies() throws PolicyNotFoundException,BadRequestException;

	public Policy addPolicies(Policy policy) throws PolicyAlreadyExistsException,BadRequestException;

	public Optional<Policy> getPolicyById(int policyId) throws PolicyNotFoundException,BadRequestException;


}
