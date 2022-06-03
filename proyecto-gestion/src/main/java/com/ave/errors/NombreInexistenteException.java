package com.ave.errors;

import javax.xml.ws.WebFault;

@WebFault(name = "NombreInexistenteException")
public class NombreInexistenteException extends Exception {
	private DetalleError faultInfo;

	public NombreInexistenteException() {
	}

	public NombreInexistenteException(String message, DetalleError faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public NombreInexistenteException(String message, DetalleError faultInfo, Throwable cause) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public DetalleError getFaultInfo() {
		return faultInfo;
	}
}