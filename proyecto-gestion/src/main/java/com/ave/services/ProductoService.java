package com.ave.services;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.ave.entities.Producto;

public class ProductoService {

	private EntityManager em;

	Logger logger = Logger.getLogger(Producto.class.getName());

	public ProductoService(EntityManager em) {
		super();
		this.em = em;
	}

	public Producto recuperarProduto(Producto producto) {
		return producto;		
	}
}
