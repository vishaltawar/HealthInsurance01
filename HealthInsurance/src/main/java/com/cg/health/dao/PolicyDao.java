package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.Policy;

@Repository
public interface PolicyDao extends JpaRepository<Policy, Integer> {

}
