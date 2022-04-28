package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.Admin;

@Repository
public  interface AdminDao extends JpaRepository<Admin, Integer>{
	@Query("select a from Admin a where a.adminId=?1 and a.password=?2")
	public Admin getPassword( int adminId,String password);
}
