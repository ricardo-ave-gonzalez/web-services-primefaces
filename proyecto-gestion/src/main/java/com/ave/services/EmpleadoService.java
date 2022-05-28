package com.ave.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.ave.entities.Empleado;
import com.ave.entities.I_EmpleadoRepository;

@WebService(serviceName = "servicio_saludar")
public class EmpleadoService implements I_EmpleadoRepository {

	@WebMethod(operationName = "bonjour")
	@SOAPBinding(style = Style.DOCUMENT)
	public Empleado getEmpleadoById(String id) {
		
		return new Empleado("abc123", "Richardsito");
	}

}
