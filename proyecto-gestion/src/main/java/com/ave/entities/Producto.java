package com.ave.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto extends ResultadoBase {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="descripcion")
	private String descripcion;	

	@Column(name="precio")
	private Double precio;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Producto(String id, String descripcion, Double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
