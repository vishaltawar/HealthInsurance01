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
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.service.AdminService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/health")
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	@GetMapping(value="/admins", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Admin>> getAdminList(){
		 List<Admin> adminlist=adminService.getAdmin();
		 if(adminlist.isEmpty())
		 {
			 return new ResponseEntity("Sorry! Admin not available!",
					 HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<List<Admin>>(adminlist, HttpStatus.OK);
	}
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin1){
		Admin admin2= adminService.addAdmin(admin1);
		if(admin2==null)
		{
			return new ResponseEntity("Sorry! Admin not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin2, HttpStatus.OK);
	}
	
	@GetMapping(value="/admins/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Optional <Admin>> getAdminById(@PathVariable int id){
		Optional<Admin> admin1= adminService.getAdminById(id);
		if(admin1==null)
		{
			//return Optional.empty();
			return new ResponseEntity("Sorry! Admin not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Admin>>(admin1, HttpStatus.OK);
	}
	@PostMapping(path = "/login/{adminId}/{password}")
	public Admin loginService(@PathVariable("adminId") int adminId, @PathVariable("password") String password)
			throws AdminNotFoundException {

		Admin a1 = adminService.loginService(adminId, password);
		if (a1 == null)
			throw new AdminNotFoundException("Invalid userId and user Password");
		else
			return a1;
 
}
}

