package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.PolicyUser;

@Repository
public interface PolicyUserDao extends JpaRepository<PolicyUser, Integer> {
	@Query("select u from PolicyUser u where u.userName=?1 and u.password=?2")
	public PolicyUser validateUser(String userName, String password);

}