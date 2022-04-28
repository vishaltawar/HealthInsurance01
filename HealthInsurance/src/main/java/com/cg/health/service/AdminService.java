package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import com.cg.health.entities.Admin;
import com.cg.health.exception.AdminAlreadyExistsException;
import com.cg.health.exception.AdminNotFoundException;

public interface AdminService {

	public List<Admin> getAdmin() throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException;

	public Optional<Admin> getAdminById(int adminId) throws AdminNotFoundException;

	public Admin loginService(int adminId, String password);
}
