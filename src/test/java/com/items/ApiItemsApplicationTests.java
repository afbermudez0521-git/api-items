package com.items;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.items.entitys.Productos;
import com.items.services.IItemsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiItemsApplicationTests {

	@Autowired
	IItemsService iItemsService;
	
	@Autowired
	RestTemplate registrarTemplate;
	
	@Test
	void contextLoads() {
		Productos data = this.registrarTemplate.getForObject("http://localhost:8084/productos/2", Productos.class);
		System.out.println(data.getNombre());
	}

}
