package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.PolicyPurchase;

@Repository
public interface PolicyPurchaseDao extends JpaRepository<PolicyPurchase, Long>{

}
