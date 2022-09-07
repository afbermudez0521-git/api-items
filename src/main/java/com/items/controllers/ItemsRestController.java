package com.items.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.items.entitys.Items;
import com.items.entitys.Productos;
import com.items.services.IItemsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
@RequestMapping("items")
public class ItemsRestController {

	private static Logger log = LoggerFactory.getLogger(ItemsRestController.class);
	
	@Autowired
	IItemsService iItemsService;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@Value("${server.port}")
	private String puerto;
	
	@GetMapping
	public List<Items> Listar(){
		return this.iItemsService.FindAll();
	}
	
	@GetMapping("/getConfig")
	public ResponseEntity<?> GetCongig(){
		HashMap<String, String> json = new HashMap<String, String>();
		json.put("texto", this.texto);
		json.put("puerto", this.puerto);
		
		log.info(texto);
		log.info(puerto);
		return new ResponseEntity<HashMap<String, String>>(json, HttpStatus.OK);
	}
	
	@HystrixCommand(fallbackMethod = "ListarIdAlternative")
	@GetMapping("/{id}/cantidad/{cantidad}")
	public Items ListarId(@PathVariable Long id, @PathVariable Integer cantidad){
		return this.iItemsService.FindById(id, cantidad);
	}
	
	public Items ListarIdAlternative(Long id, Integer cantidad){
		Items items = new Items();
		Productos productos = new Productos();
		
		productos.setNombre("Lavadora");
		productos.setPrecio("700000");
		productos.setFecha(new Date());
		items.setCantidad(1);
		items.setProductos(productos);
		
		return items;
	}
}
