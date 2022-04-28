package com.cg.health;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.health.dao.AdminDao;
import com.cg.health.dao.PolicyDao;
import com.cg.health.entities.Admin;
import com.cg.health.entities.Policy;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.service.AdminService;
import com.cg.health.service.PolicyService;

@SpringBootTest
public class PolicyTestJunitMock {
	@Autowired
	PolicyService policyService;

	
	
	@MockBean
	PolicyDao policyDao;

	private Policy p1 =new Policy();

	@BeforeEach
	void setUp() {
	   
		p1.setPolicyId(1);;
		p1.setPolicyCost(200000);;
		p1.setPolicyName("Individual");;
		p1.setPolicyDurationInYear(2);
		
	}

	@Test
	void testAddPolicy() {

		Mockito.when(policyDao.save(p1)).thenReturn(p1);
		assertThat(policyService.addPolicies(p1)).isEqualTo(p1);
	}
	
	
	@Test
	void testGetPolicies() throws PolicyNotFoundException {
		Policy p2 =new Policy();
		p1.setPolicyId(2);;
		p1.setPolicyCost(300000);;
		p1.setPolicyName("SecureHealth");;
		p1.setPolicyDurationInYear(2);;
		List<Policy> policyList = new ArrayList<>();
		policyList.add(p1);
		policyList.add(p2);
		Mockito.when(policyDao.findAll()).thenReturn(policyList);
		assertThat(policyService.getPolicies()).isEqualTo(policyList);
	}
	@Test
	public void testGetPolicyById() {	
		Optional<Policy> p2=Optional.of(p1);
   Mockito.when(policyDao.findById(1)).thenReturn(p2);
   assertThat(policyService.getPolicyById(1)).isEqualTo(p2);
	}
}
