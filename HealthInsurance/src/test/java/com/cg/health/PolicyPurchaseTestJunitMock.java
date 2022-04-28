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

import com.cg.health.dao.PolicyPurchaseDao;
import com.cg.health.entities.PolicyPurchase;
import com.cg.health.exception.PolicyPurchaseNotFoundException;
import com.cg.health.service.PolicyPurchaseService;

@SpringBootTest
public class PolicyPurchaseTestJunitMock {
	@Autowired
	PolicyPurchaseService purchaseService;

	
	
	@MockBean
	PolicyPurchaseDao purchaseDao;

	private PolicyPurchase a1 =new PolicyPurchase();

	@BeforeEach
	void setUp() {
	   
		a1.setPolicy(null);;
		a1.setPolicyPuchaseDuration(2);;
		a1.setPolicyPurchaseId(1);;
		a1.setPolicyUser(null);;
		a1.setPremiumAmount(5000);;
		a1.setPurchaseDate(null);
		a1.setPurchaseEndDate(null);
	}

	@Test
	void testAddAdmin() {

		Mockito.when(purchaseDao.save(a1)).thenReturn(a1);
		assertThat(purchaseService.addPolicyPurchase(a1)).isEqualTo(a1);
	}
	
	
	@Test
	void testGetPolicyPurchase() throws PolicyPurchaseNotFoundException {
		PolicyPurchase a2 =new PolicyPurchase();
		a1.setPolicy(null);;
		a1.setPolicyPuchaseDuration(2);;
		a1.setPolicyPurchaseId(2);;
		a1.setPolicyUser(null);;
		a1.setPremiumAmount(5000);;
		a1.setPurchaseDate(null);
		a1.setPurchaseEndDate(null);
		List<PolicyPurchase> purchaseList = new ArrayList<>();
		purchaseList.add(a1);
		purchaseList.add(a2);
		Mockito.when(purchaseDao.findAll()).thenReturn(purchaseList);
		assertThat(purchaseService.getPolicyPurchase()).isEqualTo(purchaseList);
	}
	@Test
	public void testGetAdminById() {	
		Optional<PolicyPurchase> a2=Optional.of(a1);
   Mockito.when(purchaseDao.findById(1l)).thenReturn(a2);
   assertThat(purchaseService.getPolicyPurchaseUserById(1)).isEqualTo(a2);
	}
}
