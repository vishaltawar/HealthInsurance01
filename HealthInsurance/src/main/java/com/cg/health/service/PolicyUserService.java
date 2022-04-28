package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.PolicyUserAlreadyExistsException;
import com.cg.health.exception.PolicyUserNotFoundException;

public interface PolicyUserService {
	

	public List<PolicyUser> getUsers() throws PolicyUserNotFoundException;

	public PolicyUser addUser(PolicyUser user)throws PolicyUserAlreadyExistsException;

	public Optional<PolicyUser> getPolicyUserById(int userId) throws PolicyUserNotFoundException;

	public PolicyUser loginUser(String userName, String password) throws PolicyUserNotFoundException;
}