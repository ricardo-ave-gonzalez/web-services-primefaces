package com.ave.entities;

public class ResultadoBase {

	private Error error = new Error();

	public void setErrorE(String codigo, String mensaje, String except) {
		this.error = new Error();
		error.setHayError(true);
		error.setCodigoError(codigo);
		error.setMsgError(mensaje);
	}
	
	public void setError(String codigo, String mensaje) {
		this.error = new Error();
		error.setHayError(true);
		error.setCodigoError(codigo);
		error.setMsgError(mensaje);
	}
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
}
