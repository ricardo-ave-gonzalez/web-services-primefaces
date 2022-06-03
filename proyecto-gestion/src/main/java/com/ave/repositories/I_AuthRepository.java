package com.ave.repositories;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.ave.errors.NombreInexistenteException;

@WebService(serviceName = "servicio_login")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface I_AuthRepository {

	// @WebMethod
	// public String authTest(String username, String password);

	@WebMethod(operationName = "getTrueLogin")
	public boolean login(
			@WebParam(name = "username") String username, 
			@WebParam(name = "password") String password
			) throws NombreInexistenteException;

}
