package com.items.entitys;

import java.io.Serializable;

public class Items implements Serializable{

	private Productos productos;
	private Integer cantidad;
	
	public Double getTotal() {
		return (Integer.parseInt(productos.getPrecio())*cantidad.doubleValue());
	}
	
	public Items() {
	}
	
	public Items(Productos productos, int cantidad) {
		this.productos = productos;
		this.cantidad = cantidad;
	}
	
	public Productos getProductos() {
		return productos;
	}



	public void setProductos(Productos productos) {
		this.productos = productos;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
