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

import com.cg.health.dao.PolicyUserDao;
import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.service.PolicyUserService;

@SpringBootTest
public class PolicyUserTestJunitMock {
	@Autowired
	PolicyUserService userService;

	
	
	@MockBean
	PolicyUserDao userDao;

	private PolicyUser u1 =new PolicyUser();

	@BeforeEach
	void setUp() {
	   
		u1.setUserId(1);
		u1.setUserName("Mohammed Khizer");
		u1.setPassword("Kiz@123");
		u1.setEmailId("Kiz@gmail.com");
		u1.setPhoneNo(987654321);
		u1.setAadhaarNo(654378678);
		u1.setDob(null);
	}

	@Test
	void testAddAdmin() {

		Mockito.when(userDao.save(u1)).thenReturn(u1);
		assertThat(userService.addUser(u1)).isEqualTo(u1);
	}
	
	
	@Test
	void testGetAdmins() throws AdminNotFoundException {
		PolicyUser u2 =new PolicyUser();
		u2.setUserId(2);
		u2.setUserName("Vishal");
		u2.setPassword("vis@123");
		u2.setEmailId("vis@gmail.com");
		u2.setPhoneNo(987687321);
		u2.setAadhaarNo(565673674);
		u2.setDob(null);
		List<PolicyUser> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		Mockito.when(userDao.findAll()).thenReturn(userList);
		assertThat(userService.getUsers()).isEqualTo(userList);
	}
	@Test
	public void testGetAdminById() {	
		Optional<PolicyUser> u2=Optional.of(u1);
   Mockito.when(userDao.findById(1)).thenReturn(u2);
   assertThat(userService.getPolicyUserById(1)).isEqualTo(u2);
	}
	
}
