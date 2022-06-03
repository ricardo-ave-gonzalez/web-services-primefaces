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
import com.ave.errors.NombreInexistenteException;
import com.ave.repositories.I_AuthRepository;

@WebService(endpointInterface = "com.ave.repositories.I_AuthRepository")
public class AuthService implements I_AuthRepository {

	@Resource
	private WebServiceContext context;

	@PersistenceContext
	EntityManager em = new ConectorJPA().getEntityManager();

	public AuthService() {
	}

	public AuthService(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public boolean login(String username, String password) throws NombreInexistenteException{
		System.out.println(username);
		System.out.println(password);
		try {

			List<Usuario> users = new ArrayList<>();
			users = (List<Usuario>) em.createNamedQuery("Usuario.findByUserNameAndPassword", Usuario.class)
					.setParameter("username", username).setParameter("password", password).getResultList();
			int matchCounter = 0;
		    matchCounter = users.size();
		    if (matchCounter == 1) {
		        return true;
		    }
		    throw new NombreInexistenteException("I am testing", null);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
