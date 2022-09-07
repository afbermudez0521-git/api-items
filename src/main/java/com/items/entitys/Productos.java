package com.items.entitys;

import java.io.Serializable;
import java.util.Date;
public class Productos implements Serializable{

	private long id;
	
	private String nombre;
	
	private String precio;
	
	private Date fecha;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
