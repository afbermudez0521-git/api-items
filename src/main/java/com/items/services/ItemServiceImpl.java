package com.items.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.clienteRest.ProductosFeign;
import com.items.entitys.Items;
import com.items.entitys.Productos;

@Service
public class ItemServiceImpl implements IItemsService {

	@Autowired
	private ProductosFeign productosFeign;
	
	@Override
	public List<Items> FindAll() {
		List<Productos> productos = this.productosFeign.FindAll();
		return productos.stream().map(p -> new Items(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Items FindById(Long id, Integer cantidad) {
		Productos producto = this.productosFeign.FindById(id);
		return new Items(producto, cantidad);
	}
	
	//HttpClient Manera 1
	/*@Autowired
	RestTemplate registrarTemplate;*/
	
	/*@Override
	public List<Items> FindAll() {
		List<Productos> productos = Arrays.asList(this.registrarTemplate.getForObject("http://localhost:8084/productos", Productos[].class));
		return productos.stream().map(p -> new Items(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Items FindById(Long id, Integer cantidad) {
		Productos producto = this.registrarTemplate.getForObject("http://localhost:8084/productos/"+id, Productos.class);
		return new Items(producto, cantidad);
	}*/

}
