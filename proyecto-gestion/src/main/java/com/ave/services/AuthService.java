package com.ave.services;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.ave.entities.Usuario;
import com.ave.repositories.I_AuthRepository;

@WebService(endpointInterface = "com.ave.repositories.I_AuthRepository")
public class AuthService implements I_AuthRepository{
	
	@Resource
	private WebServiceContext context;
	
	private EntityManager em;

	public String authTest(String username, String password) {

		MessageContext mc = context.getMessageContext();
		Map requestHeader = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) requestHeader.get("username");
		List passList = (List) requestHeader.get("password");
		//String username = "";
		//String password = "";
		if(userList!=null&&passList!=null) {
			username = (String) userList.get(0);
			password = (String) passList.get(0);			
		}
		if("admin".equals(username)&&"admin".equals(password)) {
			return "Bonjour " + username;
		} else {
			return "Verifique los datos por favor.";
		}	
	}
	
	@Transactional
	public boolean login(String username, String password) {
		
		try {
			
			EntityTransaction entr = em.getTransaction();
			entr.begin();

			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.password = ?2", Usuario.class);
			query.setParameter(1, username);
			query.setParameter(2, password);
			try {
				Usuario user = (Usuario) query.getSingleResult();
				return true;
			} catch (javax.persistence.NoResultException e) {
				return false;
			}
		} finally {
			em.close();
		}
	}
}
