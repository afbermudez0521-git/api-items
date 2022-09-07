package com.items.clienteRest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.items.entitys.Productos;

@FeignClient(name = "servicio-productos")
public interface ProductosFeign {

	@GetMapping("/productos")
	public List<Productos> FindAll();
	
	@GetMapping("/productos/{id}")
	public Productos FindById(@PathVariable long id);
	
}
