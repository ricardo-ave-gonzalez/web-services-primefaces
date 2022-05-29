package com.ave.repositories;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface I_AuthRepository {
	
	@WebMethod	
    public String authTest(String username, String password);
	
	@WebMethod
	public boolean login(String username, String password);
}
