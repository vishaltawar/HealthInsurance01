package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.PolicyUserDao;
import com.cg.health.entities.Admin;
import com.cg.health.entities.Policy;
import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.exception.PolicyUserAlreadyExistsException;
import com.cg.health.exception.PolicyUserNotFoundException;

@Service
public class PolicyUserServiceImpl implements PolicyUserService {
	
    @Autowired
	private PolicyUserDao userDao; 
	@Override
	public List<PolicyUser> getUsers() throws PolicyUserNotFoundException {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public PolicyUser addUser(PolicyUser user) throws PolicyUserAlreadyExistsException{
		if(userDao.existsById(user.getUserId())) {
			throw new PolicyUserAlreadyExistsException();
		}
		return userDao.save(user);
	}
	@Override
	public Optional<PolicyUser> getPolicyUserById(int userId) throws PolicyUserNotFoundException {
		 PolicyUser policyUser;
	        if (userDao.findById(userId).isEmpty()) {
	            throw new PolicyUserNotFoundException();
	        } else {
	            policyUser = userDao.findById(userId).get();
	        }
	        return Optional.of(policyUser);
	    }
	@Override
	public PolicyUser loginUser(String userName, String password) throws PolicyUserNotFoundException {
		
		PolicyUser user1=userDao.validateUser(userName,password);
		return user1;
	}
 
	
}