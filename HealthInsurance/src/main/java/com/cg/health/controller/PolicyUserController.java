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

import com.cg.health.entities.Admin;
import com.cg.health.entities.Policy;
import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.exception.PolicyUserNotFoundException;
import com.cg.health.service.PolicyUserService;
@CrossOrigin(origins= "http://localhost:3000/")
@RestController
@RequestMapping("/health/policyuser")
public class PolicyUserController {
	@Autowired
	public PolicyUserService userService;
	@GetMapping("/getall")
	public List<PolicyUser> getUsers(){
		return userService.getUsers() ;
	}
	@PostMapping("/add")
	public PolicyUser addUser(@RequestBody PolicyUser user){
		return userService.addUser(user);
	}
//	@GetMapping("/InsuranceUser/{userId}")
//	public PolicyUser getPolicyUserById(@PathVariable int userId){
//		return userService.getPolicyUserById(userId);
//	}
	@GetMapping(value="/get/{userId}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Optional<PolicyUser>> getPolicyUserById(@PathVariable int userId){
		Optional<PolicyUser> policyUser1= userService.getPolicyUserById(userId);
		if(policyUser1==null)
		{
			return new ResponseEntity("Sorry! Policy not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<PolicyUser>>(policyUser1, HttpStatus.OK);
	}
	@PostMapping(path = "/userLogin")
	public PolicyUser loginValidation(@RequestBody PolicyUser user)
	
			throws PolicyUserNotFoundException {

		PolicyUser u1 = userService.loginUser(user.getUserName(), user.getPassword());
		if (u1 == null)
			throw new PolicyUserNotFoundException("Invalid userId and user Password");
		else
			return u1;
 
}
}

//validate/login policyUser