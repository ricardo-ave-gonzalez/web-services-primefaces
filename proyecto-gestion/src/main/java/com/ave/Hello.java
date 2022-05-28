package com.ave;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(serviceName = "servicio_saludar")
@SOAPBinding(style = Style.DOCUMENT)
public class Hello {

	@WebMethod(operationName = "bonjour")
	public String bonjour(String name, String lastName) {
		return "Bonjour " + name + " " +lastName;
	}
}