package com.ave.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.EntityManager;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.ave.entities.Usuario;
import com.ave.repositories.I_UsuarioRepository;

@WebService(serviceName = "servicio_usuario")
public class UsuarioService implements I_UsuarioRepository {

	private EntityManager em;

	public UsuarioService() {
	}

	public UsuarioService(EntityManager em) {
		this.em = em;
	}

	@Override
	@WebMethod(operationName = "getAllUser")
	@SOAPBinding(style = Style.DOCUMENT)
	public List<Usuario> getAll() {
		List<Usuario> list = new ArrayList<>();
		try {
			list = (List<Usuario>) em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

			em.close();
		} catch (Exception e) {
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println(e);
		}
		return list;
	}

	

}
