package com.ave.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

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

	public String authTest(String username, String password) {

		MessageContext mc = context.getMessageContext();
		Map requestHeader = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) requestHeader.get("username");
		List passList = (List) requestHeader.get("password");
		// String username = "";
		// String password = "";
		if (userList != null && passList != null) {
			username = (String) userList.get(0);
			password = (String) passList.get(0);
		}
		if ("admin".equals(username) && "admin".equals(password)) {
			return "Bonjour " + username;
		} else {
			return "Verifique los datos por favor.";
		}
	}

	
	@Transactional
	public boolean login(String username, String password) {
		System.out.println(username);
		System.out.println(password); 
		try {

			System.out.println("****************************************************************");
			System.out.println("entro al trycatch");
			
			List<Usuario> users = new ArrayList<>(); 
			users = (List<Usuario>) em
					.createNamedQuery(
							"Usuario.findByUserNameAndPassword", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getResultList();
			
			Usuario usuario = users.get(0);
			
			System.out.println("IMPRIMO USUARIO");
			System.out.println(usuario); 
			em.close();
			return true;
		} catch (NullPointerException ex) {
			ex.printStackTrace();			
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("****************************************************************");
			System.out.println("entro x el finally");
		}
		return false;
	}

}
