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
import com.cg.health.entities.Admin;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.service.AdminService;
import com.cg.health.dao.AdminDao;

@SpringBootTest
class AdminTestJunitMock {

			
	@Autowired
	AdminService adminService;

	
	
	@MockBean
	AdminDao adminDao;

	private Admin a1 =new Admin();

	@BeforeEach
	void setUp() {
	   
		a1.setAdminId(1);
		a1.setFirstName("Mohammed");
		a1.setLastName("Khizer");
		a1.setUserName("Kiz");
		a1.setPassword("Kiz@123");
		a1.setEmailId("Kiz@gmail.com");
		a1.setPhoneNumber(987654321);
	}

	@Test
	void testAddAdmin() {

		Mockito.when(adminDao.save(a1)).thenReturn(a1);
		assertThat(adminService.addAdmin(a1)).isEqualTo(a1);
	}
	
	
	@Test
	void testGetAdmins() throws AdminNotFoundException {
		Admin a2 = new Admin();
		a2.setAdminId(2);
		a2.setFirstName("Vivek");
		a2.setLastName("Nanda");
		a2.setUserName("Viv");
		a2.setPassword("Viv@123");
		a2.setEmailId("Viv@gmail.com");
		a2.setPhoneNumber(978645435);
		List<Admin> adminList = new ArrayList<>();
		adminList.add(a1);
		adminList.add(a2);
		Mockito.when(adminDao.findAll()).thenReturn(adminList);
		assertThat(adminService.getAdmin()).isEqualTo(adminList);
	}
	@Test
	public void testGetAdminById() {	
		Optional<Admin> a2=Optional.of(a1);
   Mockito.when(adminDao.findById(1)).thenReturn(a2);
   assertThat(adminService.getAdminById(1)).isEqualTo(a2);
	}
	}
