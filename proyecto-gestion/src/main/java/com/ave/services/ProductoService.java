package com.ave.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceContext;

import com.ave.component.ConectorJPA;
import com.ave.entities.Producto;
import com.ave.repositories.I_ProductoRepository;

public class ProductoService  implements I_ProductoRepository{

	@Resource
	private WebServiceContext context;

	@PersistenceContext
	EntityManager em = new ConectorJPA().getEntityManager();
	Logger logger = Logger.getLogger(Producto.class.getName());

	public ProductoService() {}

	public ProductoService(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public void save(Producto producto) {
		if(producto==null) return;
		try {
	        em.getTransaction().begin();
	        em.persist(producto);
	        em.getTransaction().commit();
	        em.close();	
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			return;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Producto producto) {
		if(producto==null) return;
		try {
	        em.getTransaction().begin();
	        em.remove(em.merge(producto));
	        em.getTransaction().commit();
	        em.close();	
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			return;
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Producto> getAll() {
		List<Producto> list=new ArrayList<>();
        list=(List<Producto>)em.createQuery("SELECT u FROM Producto u", Producto.class).getResultList();
        em.close();
        return list;
	}
}
