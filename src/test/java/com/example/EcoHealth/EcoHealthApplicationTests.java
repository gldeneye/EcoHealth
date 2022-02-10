package com.example.EcoHealth;

import com.example.EcoHealth.Repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class EcoHealthApplicationTests {

    @Autowired
    CustomerRepository custRepo;

	@Test
	void testGetCustomers() {
		Assertions.assertEquals(4, custRepo.getCustomers().size());
	}

	@Test
	void testCheckPassword() {
		Assertions.assertEquals(true, custRepo.checkPassword("720327-5935", "ww"));
	}


}
