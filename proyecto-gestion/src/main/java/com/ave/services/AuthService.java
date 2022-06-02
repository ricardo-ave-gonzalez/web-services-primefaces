package com.ave.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.ws.WebServiceContext;

import com.ave.component.ConectorJPA;
import com.ave.entities.Usuario;
import com.ave.repositories.I_AuthRepository;

@WebService(endpointInterface = "com.ave.repositories.I_AuthRepository")
public class AuthService implements I_AuthRepository {

	@Resource
	private WebServiceContext context;

	@PersistenceContext
	EntityManager em = new ConectorJPA().getEntityManager();
		
	public AuthService() {}

	public AuthService(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public boolean login(String username, String password) {
		System.out.println(username);
		System.out.println(password); 
		try {
			
			List<Usuario> users = new ArrayList<>(); 
			users = (List<Usuario>) em
					.createNamedQuery(
							"Usuario.findByUserNameAndPassword", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getResultList();
			
			//Usuario usuario = users.get(0);
			
			System.out.println("IMPRIMO USUARIO");
			System.out.println(users); 
			//em.close();
			return true;
		} catch (NullPointerException ex) {
			ex.printStackTrace();			
			return false;
		}
	}

}
